package com.xwc1125.telegrambot.request;

import com.xwc1125.telegrambot.response.StringResponse;

/**
 * Stas Parshin
 * 01 July 2017
 */
public class ExportChatInviteLink extends BaseRequest<ExportChatInviteLink, StringResponse> {

    public ExportChatInviteLink(Object chatId) {
        super(StringResponse.class);
        add("chat_id", chatId);
    }
}
