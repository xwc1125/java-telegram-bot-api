package com.xwc1125.telegrambot;

import com.google.gson.Gson;
import com.xwc1125.telegrambot.impl.FileApi;
import com.xwc1125.telegrambot.impl.TelegramBotClient;
import com.xwc1125.telegrambot.impl.UpdatesHandler;
import com.xwc1125.telegrambot.model.File;
import com.xwc1125.telegrambot.model.Message;
import com.xwc1125.telegrambot.model.Update;
import com.xwc1125.telegrambot.request.*;
import com.xwc1125.telegrambot.response.BaseResponse;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import com.xwc1125.telegrambot.response.GetMeResponse;
import com.xwc1125.telegrambot.response.GetUpdatesResponse;
import com.xwc1125.telegrambot.response.SendResponse;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Stas Parshin
 * 16 October 2015
 */
public class TelegramBot {

    private final TelegramBotClient api;
    private final FileApi fileApi;
    private final UpdatesHandler updatesHandler;

    /**
     * 构造函数
     *
     * @param botToken
     */
    public TelegramBot(String botToken) {
        this(new Builder(botToken));
    }

    /**
     * @param builder
     */
    TelegramBot(Builder builder) {
        this.api = builder.api;
        this.fileApi = builder.fileApi;
        this.updatesHandler = builder.updatesHandler;
    }

    /**
     * sync
     *
     * @param request
     * @param <T>
     * @param <R>
     * @return
     */
    public <T extends BaseRequest, R extends BaseResponse> R execute(BaseRequest<T, R> request) {
        return api.send(request);
    }

    /**
     * async
     *
     * @param request
     * @param callback
     * @param <T>
     * @param <R>
     */
    public <T extends BaseRequest<T, R>, R extends BaseResponse> void execute(T request, Callback<T, R> callback) {
        api.send(request, callback);
    }

    /**
     * @param file
     * @return
     */
    public String getFullFilePath(File file) {
        return fileApi.getFullFilePath(file.filePath());
    }

    /**
     * @param file
     * @return
     * @throws Exception
     */
    public byte[] getFileContent(File file) throws Exception {
        String fileUrl = getFullFilePath(file);
        URLConnection connection = new URL(fileUrl).openConnection();
        InputStream is = connection.getInputStream();
        byte[] data = BotUtils.getBytesFromInputStream(is);
        is.close();
        return data;
    }

    /**
     * listener
     *
     * @param listener
     */
    public void setUpdatesListener(UpdatesListener listener) {
        setUpdatesListener(listener, new GetUpdates());
    }

    /**
     * listener
     *
     * @param listener
     * @param request
     */
    public void setUpdatesListener(UpdatesListener listener, GetUpdates request) {
        updatesHandler.start(this, listener, request);
    }

    /**
     * stop listener
     */
    public void removeGetUpdatesListener() {
        updatesHandler.stop();
    }

    // ===============Method===============

    /**
     * getMe
     *
     * @return
     */
    public GetMeResponse getMe() {
        GetMe getMe = new GetMe();
        return this.execute(getMe);
    }

    /**
     * sendMessage
     *
     * @param message
     * @param text
     * @return
     */
    public SendResponse text(Message message, String text) {
        SendMessage sendMessage = new SendMessage(message.chat().id(), text);
        return this.execute(sendMessage);
    }

    /**
     * sendMessage
     *
     * @param chatId
     * @param text
     * @return
     */
    public SendResponse text(Object chatId, String text) {
        SendMessage sendMessage = new SendMessage(chatId, text);
        return this.execute(sendMessage);
    }

    /**
     * sendPhoto
     *
     * @param chatId
     * @param photo  图片的URL链接
     */
    public SendResponse photo(Object chatId, String photo) {
        SendPhoto sendPhoto = new SendPhoto(chatId, photo);
        SendResponse execute = this.execute(sendPhoto);
        return execute;
    }

    /**
     * 发送图片
     *
     * @param message
     * @param file
     */
    public SendResponse photo(Message message, java.io.File file) {
        return photo(message.chat().id(), file);
    }

    public SendResponse photo(Object chatId, java.io.File file) {
        SendPhoto sendPhoto = new SendPhoto(chatId, file);
        SendResponse response = this.execute(sendPhoto);
        return response;
    }
    // ==============Builder==============

    /**
     *
     */
    public static final class Builder {
        /**
         * api url()
         */
        static final String API_URL = "https://api.telegram.org/bot";

        private final String botToken;
        private FileApi fileApi;
        private TelegramBotClient api;
        private UpdatesHandler updatesHandler;

        private OkHttpClient okHttpClient;
        private String apiUrl;
        private String fileApiUrl;

        /**
         * @param botToken
         */
        public Builder(String botToken) {
            this.botToken = botToken;
            api = new TelegramBotClient(client(null), gson(), apiUrl(API_URL, botToken));
            fileApi = new FileApi(botToken);
            updatesHandler = new UpdatesHandler(100);
        }

        /**
         * @return
         */
        public Builder debug() {
            okHttpClient = client(httpLoggingInterceptor());
            return this;
        }

        /**
         * @param client
         * @return
         */
        public Builder okHttpClient(OkHttpClient client) {
            okHttpClient = client;
            return this;
        }

        /**
         * change the api url
         *
         * @param apiUrl url must like :https://xxxx/bot
         * @return
         */
        public Builder apiUrl(String apiUrl) {
            this.apiUrl = apiUrl;
            return this;
        }

        /**
         * @param fileApiUrl
         * @return
         */
        public Builder fileApiUrl(String fileApiUrl) {
            this.fileApiUrl = fileApiUrl;
            return this;
        }

        /**
         * @param millis
         * @return
         */
        public Builder updateListenerSleep(long millis) {
            updatesHandler = new UpdatesHandler(millis);
            return this;
        }

        /**
         * @return
         */
        public TelegramBot build() {
            if (okHttpClient != null || apiUrl != null) {
                OkHttpClient client = okHttpClient != null ? okHttpClient : client(null);
                String baseUrl = apiUrl(apiUrl != null ? apiUrl : API_URL, botToken);
                api = new TelegramBotClient(client, gson(), baseUrl);
            }
            if (fileApiUrl != null) {
                fileApi = new FileApi(fileApiUrl, botToken);
            }
            return new TelegramBot(this);
        }

        /**
         * @param interceptor
         * @return
         */
        private static OkHttpClient client(Interceptor interceptor) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            if (interceptor != null) {
                builder.addInterceptor(interceptor);
            }
            return builder.build();
        }

        /**
         * @return
         */
        private static Interceptor httpLoggingInterceptor() {
            return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        }

        private static Gson gson() {
            return new Gson();
        }

        /**
         * Stitching strings
         *
         * @param apiUrl
         * @param botToken
         * @return
         */
        private static String apiUrl(String apiUrl, String botToken) {
            return apiUrl + botToken + "/";
        }
    }

    // ========================================

    private volatile boolean startUpdates;
    private volatile boolean stopUpdates;
    private Map<String, Consumer<Message>> textMappings = new HashMap<>();
    private Consumer<Message> stickerMapping = null;
    private Consumer<Message> othersMapping = null;

    /**
     * 启动机器人后发的消息
     *
     * @param consumer
     * @return
     */
    public TelegramBot onStart(Consumer<Message> consumer) throws Exception {
        return this.onCmd("/start", consumer);
    }

    /**
     * 输入 /help 指令后
     *
     * @param consumer
     * @return
     */
    public TelegramBot onHelp(Consumer<Message> consumer) throws Exception {
        return this.onCmd("/help", consumer);
    }

    /**
     * 监听接收到贴纸
     *
     * @param consumer
     * @return
     */
    public TelegramBot onSticker(Consumer<Message> consumer) {
        this.stickerMapping = consumer;
        this.start();
        return this;
    }

    /**
     * 监听除指令、贴纸、视频、图片、音频之外的消息
     *
     * @param consumer
     * @return
     */
    public TelegramBot onOthers(Consumer<Message> consumer) {
        this.othersMapping = consumer;
        this.start();
        return this;
    }

    /**
     * 监听指令
     *
     * @param cmdText  指令文本
     * @param consumer 处理器
     * @return
     */
    public TelegramBot onCmd(String cmdText, Consumer<Message> consumer) throws Exception {
        if (textMappings.containsKey(cmdText)) {
            throw new Exception("请不要重复监听相同指令.");
        }
        textMappings.put(cmdText, consumer);
        this.start();
        return this;
    }

    /**
     * 调用start
     *
     * @return
     */
    private TelegramBot start() {
        if (!startUpdates) {
            System.out.println("Start listen bot message :)");
            startUpdates = true;
            GetUpdates getUpdates = new GetUpdates();
            this.getUpdates(getUpdates);
        }
        return this;
    }

    /**
     * 获取最新数据
     *
     * @param request
     */
    private void getUpdates(GetUpdates request) {
        if (stopUpdates) {
            return;
        }
        this.execute(request, new Callback<GetUpdates, GetUpdatesResponse>() {
            @Override
            public void onResponse(GetUpdates request, GetUpdatesResponse response) {
                if (!response.isOk() || response.updates() == null || response.updates().size() <= 0) {
                    sleep();
                    getUpdates(request);
                    return;
                }
                List<Update> updates = response.updates();
                int offset = lastUpdateId(updates) + 1;

                if (!textMappings.isEmpty()) {
                    Set<String> texts = textMappings.keySet();
                    List<Message> onTextUpdates = updates.stream()
                            .map(Update::message)
                            .filter(message -> texts.contains(message.text()))
                            .collect(Collectors.toList());

                    updates.retainAll(onTextUpdates);
                    onTextUpdates.stream().parallel().forEach(message -> textMappings.get(message.text()).accept(message));
                }

                if (null != stickerMapping) {
                    List<Message> onStickerUpdates = updates.stream()
                            .map(Update::message)
                            .filter(message -> null != message.sticker())
                            .collect(Collectors.toList());
                    // 用到了回调
                    // 获取用户发送过来的数据，然后判断是否和自己预定的命令符一致，如果一致，则发送相应的数据
                    updates.retainAll(onStickerUpdates);
                    onStickerUpdates.stream().parallel().forEach(message -> stickerMapping.accept(message));
                }

                if (null != othersMapping && updates.size() > 0) {
                    updates.stream().parallel().map(Update::message).forEach(message -> othersMapping.accept(message));
                }

                request = request.offset(offset);
                sleep();
                getUpdates(request);
            }

            @Override
            public void onFailure(GetUpdates request, IOException e) {
                e.printStackTrace();
                sleep();
                getUpdates(request);
            }
        });

    }

    private int lastUpdateId(List<Update> updates) {
        if (null == updates || updates.isEmpty()) {
            return 0;
        }
        return updates.get(updates.size() - 1).updateId();
    }

    /**
     * 休眠，单位毫秒
     */
    private void sleep() {
        try {
            TimeUnit.MILLISECONDS.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        this.stopUpdates = true;
    }

    public void await() {
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static Gson gson() {
        return new Gson();
    }

    public String toJson(Object bean) {
        return gson().toJson(bean);
    }
}
