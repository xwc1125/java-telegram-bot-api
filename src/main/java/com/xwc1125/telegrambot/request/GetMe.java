package com.xwc1125.telegrambot.request;

import com.xwc1125.telegrambot.response.GetMeResponse;

/**
 * stas
 * 5/1/16.
 */
public class GetMe extends BaseRequest<GetMe, GetMeResponse> {

    public GetMe() {
        super(GetMeResponse.class);
    }
}
