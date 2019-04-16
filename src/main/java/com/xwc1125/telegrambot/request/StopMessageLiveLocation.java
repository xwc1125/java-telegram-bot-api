package com.xwc1125.telegrambot.request;

import com.xwc1125.telegrambot.model.request.InlineKeyboardMarkup;
import com.xwc1125.telegrambot.response.BaseResponse;
import com.xwc1125.telegrambot.response.SendResponse;

/**
 * Stas Parshin
 * 12 October 2017
 */
public class StopMessageLiveLocation extends BaseRequest<StopMessageLiveLocation, BaseResponse> {

    public StopMessageLiveLocation(Object chatId, int messageId) {
        super(SendResponse.class);
        add("chat_id", chatId).add("message_id", messageId);
    }

    public StopMessageLiveLocation(String inlineMessageId) {
        super(BaseResponse.class);
        add("inline_message_id", inlineMessageId);
    }

    public StopMessageLiveLocation replyMarkup(InlineKeyboardMarkup replyMarkup) {
        return add("reply_markup", replyMarkup);
    }
}
