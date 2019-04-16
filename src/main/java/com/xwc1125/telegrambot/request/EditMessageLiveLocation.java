package com.xwc1125.telegrambot.request;

import com.xwc1125.telegrambot.model.request.InlineKeyboardMarkup;
import com.xwc1125.telegrambot.response.BaseResponse;
import com.xwc1125.telegrambot.response.SendResponse;

/**
 * Stas Parshin
 * 11 October 2017
 */
public class EditMessageLiveLocation extends BaseRequest<EditMessageLiveLocation, BaseResponse> {

    public EditMessageLiveLocation(Object chatId, int messageId, float latitude, float longitude) {
        super(SendResponse.class);
        add("chat_id", chatId).add("message_id", messageId).add("latitude", latitude).add("longitude", longitude);
    }

    public EditMessageLiveLocation(String inlineMessageId, float latitude, float longitude) {
        super(BaseResponse.class);
        add("inline_message_id", inlineMessageId).add("latitude", latitude).add("longitude", longitude);
    }

    public EditMessageLiveLocation replyMarkup(InlineKeyboardMarkup replyMarkup) {
        return add("reply_markup", replyMarkup);
    }
}
