package com.xwc1125.telegrambot.request;

import com.xwc1125.telegrambot.model.MaskPosition;
import com.xwc1125.telegrambot.response.BaseResponse;

/**
 * Stas Parshin
 * 23 July 2017
 */
public class CreateNewStickerSet extends AbstractUploadRequest<CreateNewStickerSet, BaseResponse> {

    public CreateNewStickerSet(Integer userId, String name, String title, Object pngSticker, String emojis) {
        super(BaseResponse.class, "png_sticker", pngSticker);
        add("user_id", userId);
        add("name", name);
        add("title", title);
        add("emojis", emojis);
    }

    public CreateNewStickerSet containsMasks(boolean containsMasks) {
        return add("contains_masks", containsMasks);
    }

    public CreateNewStickerSet maskPosition(MaskPosition maskPosition) {
        return add("mask_position", serialize(maskPosition)).containsMasks(true);
    }
}
