package com.xwc1125.telegrambot.request;

import com.xwc1125.telegrambot.model.request.Keyboard;
import com.xwc1125.telegrambot.response.SendResponse;

/**
 * stas
 * 5/1/16.
 */
abstract public class AbstractSendRequest<T extends AbstractSendRequest> extends BaseRequest<T, SendResponse> {

    public AbstractSendRequest(Object chatId) {
        super(SendResponse.class);
        add("chat_id", chatId);
    }

    public T disableNotification(boolean disableNotification) {
        return add("disable_notification", disableNotification);
    }

    public T replyToMessageId(int replyToMessageId) {
        return add("reply_to_message_id", replyToMessageId);
    }

    public T replyMarkup(Keyboard replyMarkup) {
        return add("reply_markup", replyMarkup);
    }
}
