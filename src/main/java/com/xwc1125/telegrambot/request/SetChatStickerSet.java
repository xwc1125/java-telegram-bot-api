package com.xwc1125.telegrambot.request;

import com.xwc1125.telegrambot.response.BaseResponse;

/**
 * Stas Parshin
 * 12 October 2017
 */
public class SetChatStickerSet extends BaseRequest<SetChatStickerSet, BaseResponse> {

    public SetChatStickerSet(Object chatId, String stickerSetName) {
        super(BaseResponse.class);
        add("chat_id", chatId).add("sticker_set_name", stickerSetName);
    }
}
