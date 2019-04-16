package com.xwc1125.telegrambot.request;

import com.xwc1125.telegrambot.response.BaseResponse;

/**
 * Stas Parshin
 * 01 July 2017
 */
public class UnpinChatMessage extends BaseRequest<UnpinChatMessage, BaseResponse> {

    public UnpinChatMessage(Object chatId) {
        super(BaseResponse.class);
        add("chat_id", chatId);
    }
}
