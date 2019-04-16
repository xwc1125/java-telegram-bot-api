package com.xwc1125.telegrambot;

import com.xwc1125.telegrambot.request.BaseRequest;
import com.xwc1125.telegrambot.response.BaseResponse;

import java.io.IOException;

/**
 * stas
 * 5/3/16.
 */
public interface Callback<T extends BaseRequest, R extends BaseResponse> {

    void onResponse(T request, R response);

    void onFailure(T request, IOException e);
}
