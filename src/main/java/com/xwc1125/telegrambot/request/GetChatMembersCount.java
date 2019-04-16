package com.xwc1125.telegrambot.request;

import com.xwc1125.telegrambot.response.GetChatMembersCountResponse;

/**
 * Stas Parshin
 * 28 May 2016
 */
public class GetChatMembersCount extends BaseRequest<GetChatMembersCount, GetChatMembersCountResponse> {

    public GetChatMembersCount(Object chatId) {
        super(GetChatMembersCountResponse.class);
        add("chat_id", chatId);
    }
}
