package com.xwc1125.telegrambot.request;

import com.xwc1125.telegrambot.response.GetStickerSetResponse;

/**
 * Stas Parshin
 * 23 July 2017
 */
public class GetStickerSet extends BaseRequest<GetStickerSet, GetStickerSetResponse> {

    public GetStickerSet(String name) {
        super(GetStickerSetResponse.class);
        add("name", name);
    }
}
