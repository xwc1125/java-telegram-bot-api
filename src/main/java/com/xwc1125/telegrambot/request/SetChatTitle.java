package com.xwc1125.telegrambot.request;

import com.xwc1125.telegrambot.response.BaseResponse;

/**
 * Stas Parshin
 * 01 July 2017
 */
public class SetChatTitle extends BaseRequest<SetChatTitle, BaseResponse> {

    public SetChatTitle(Object chatId, String title) {
        super(BaseResponse.class);
        add("chat_id", chatId).add("title", title);
    }
}
