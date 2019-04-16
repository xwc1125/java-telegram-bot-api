package com.xwc1125.telegrambot.request;

import com.xwc1125.telegrambot.response.BaseResponse;

/**
 * Stas Parshin
 * 07 December 2016
 */
public class DeleteWebhook extends BaseRequest<DeleteWebhook, BaseResponse> {

    public DeleteWebhook() {
        super(BaseResponse.class);
    }
}
