package com.xwc1125.telegrambot.request;

import com.xwc1125.telegrambot.response.BaseResponse;
import com.xwc1125.telegrambot.response.SendResponse;

/**
 * Stas Parshin
 * 03 October 2016
 */
public class SetGameScore extends BaseRequest<SetGameScore, BaseResponse> {

    public SetGameScore(int userId, int score, Object chatId, int messageId) {
        super(SendResponse.class);
        add("user_id", userId).add("score", score).add("chat_id", chatId).add("message_id", messageId);
    }

    public SetGameScore(int userId, int score, String inlineMessageId) {
        super(BaseResponse.class);
        add("user_id", userId).add("score", score).add("inline_message_id", inlineMessageId);
    }

    public SetGameScore force(boolean force) {
        return add("force", force);
    }

    public SetGameScore disableEditMessage(boolean disableEditMessage) {
        return add("disable_edit_message", disableEditMessage);
    }

    @Deprecated
    public SetGameScore editMessage(boolean editMessage) {
        return add("edit_message", editMessage);
    }
}
