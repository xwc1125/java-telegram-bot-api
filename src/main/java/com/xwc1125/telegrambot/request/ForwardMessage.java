package com.xwc1125.telegrambot.request;

import com.xwc1125.telegrambot.response.SendResponse;

/**
 * stas
 * 5/1/16.
 */
public class ForwardMessage extends BaseRequest<ForwardMessage, SendResponse> {

    public ForwardMessage(Object chatId, Object fromChatId, int messageId) {
        super(SendResponse.class);
        add("chat_id", chatId).add("from_chat_id", fromChatId).add("message_id", messageId);
    }

    public ForwardMessage disableNotification(boolean disableNotification) {
        return add("disable_notification", disableNotification);
    }
}
