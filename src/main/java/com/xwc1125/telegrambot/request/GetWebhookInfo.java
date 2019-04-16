package com.xwc1125.telegrambot.request;

import com.xwc1125.telegrambot.response.GetWebhookInfoResponse;

/**
 * Stas Parshin
 * 03 October 2016
 */
public class GetWebhookInfo extends BaseRequest<GetWebhookInfo, GetWebhookInfoResponse> {

    public GetWebhookInfo() {
        super(GetWebhookInfoResponse.class);
    }

}
