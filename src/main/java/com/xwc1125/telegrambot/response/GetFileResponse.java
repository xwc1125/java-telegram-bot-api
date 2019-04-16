package com.xwc1125.telegrambot.response;

import com.xwc1125.telegrambot.model.File;

/**
 * Stas Parshin
 * 16 October 2015
 */
public class GetFileResponse extends BaseResponse {

    private File result;

    GetFileResponse() {
    }

    public File file() {
        return result;
    }

    @Override
    public String toString() {
        return "GetFileResponse{" +
                "result=" + result +
                '}';
    }
}
