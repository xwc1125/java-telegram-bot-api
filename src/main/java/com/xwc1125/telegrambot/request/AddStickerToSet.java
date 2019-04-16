package com.xwc1125.telegrambot.request;

import com.xwc1125.telegrambot.model.MaskPosition;
import com.xwc1125.telegrambot.response.BaseResponse;

/**
 * Stas Parshin
 * 23 July 2017
 */
public class AddStickerToSet extends AbstractUploadRequest<AddStickerToSet, BaseResponse> {

    public AddStickerToSet(Integer userId, String name, Object pngSticker, String emojis) {
        super(BaseResponse.class, "png_sticker", pngSticker);
        add("user_id", userId);
        add("name", name);
        add("emojis", emojis);
    }

    public AddStickerToSet maskPosition(MaskPosition maskPosition) {
        return add("mask_position", serialize(maskPosition));
    }
}
