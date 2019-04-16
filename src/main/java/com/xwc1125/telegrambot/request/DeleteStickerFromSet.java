package com.xwc1125.telegrambot.request;

import com.xwc1125.telegrambot.response.BaseResponse;

/**
 * Stas Parshin
 * 23 July 2017
 */
public class DeleteStickerFromSet extends BaseRequest<DeleteStickerFromSet, BaseResponse> {
    public DeleteStickerFromSet(String sticker) {
        super(BaseResponse.class);
        add("sticker", sticker);
    }
}
