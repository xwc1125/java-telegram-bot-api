package com.xwc1125.telegrambot.request;

import com.xwc1125.telegrambot.response.BaseResponse;

/**
 * Stas Parshin
 * 01 July 2017
 */
public class PinChatMessage extends BaseRequest<PinChatMessage, BaseResponse> {

    public PinChatMessage(Object chatId, int messageId) {
        super(BaseResponse.class);
        add("chat_id", chatId).add("message_id", messageId);
    }

    public PinChatMessage disableNotification(boolean disableNotification) {
        return add("disable_notification", disableNotification);
    }
}
