package com.xwc1125.telegrambot.request;

import com.xwc1125.telegrambot.response.GetFileResponse;

/**
 * Stas Parshin
 * 23 July 2017
 */
public class UploadStickerFile extends AbstractUploadRequest<UploadStickerFile, GetFileResponse> {

    public UploadStickerFile(Integer userId, Object pngSticker) {
        super(GetFileResponse.class, "png_sticker", pngSticker);
        add("user_id", userId);
    }
}
