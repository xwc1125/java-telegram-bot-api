package com.xwc1125.telegrambot.response;

import com.xwc1125.telegrambot.model.Message;

/**
 * stas
 * 8/5/15.
 */
public class SendResponse extends BaseResponse {

    private Message result;

    SendResponse() {
    }

    public Message message() {
        return result;
    }

    @Override
    public String toString() {
        return "SendResponse{" +
                "result=" + result +
                '}';
    }
}
