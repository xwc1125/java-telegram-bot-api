package com.xwc1125.telegrambot.request;

import com.xwc1125.telegrambot.model.request.ChatAction;
import com.xwc1125.telegrambot.response.BaseResponse;

/**
 * stas
 * 5/2/16.
 */
public class SendChatAction extends BaseRequest<SendChatAction, BaseResponse> {

    public SendChatAction(Object chatId, String action) {
        super(BaseResponse.class);
        add("chat_id", chatId).add("action", action);
    }

    public SendChatAction(Object chatId, ChatAction action) {
        super(BaseResponse.class);
        add("chat_id", chatId).add("action", action.name());
    }
}
