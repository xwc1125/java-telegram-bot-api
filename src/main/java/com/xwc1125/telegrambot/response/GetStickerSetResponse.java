package com.xwc1125.telegrambot.response;

import com.xwc1125.telegrambot.model.StickerSet;

/**
 * Stas Parshin
 * 23 July 2017
 */
public class GetStickerSetResponse extends BaseResponse {

    private StickerSet result;

    public StickerSet stickerSet() {
        return result;
    }

    @Override
    public String toString() {
        return "GetStickerSetResponse{" +
                "result=" + result +
                '}';
    }
}
