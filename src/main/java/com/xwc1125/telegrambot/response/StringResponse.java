package com.xwc1125.telegrambot.response;

/**
 * Stas Parshin
 * 01 July 2017
 */
public class StringResponse extends BaseResponse {

    private String result;

    public String result() {
        return result;
    }

    @Override
    public String toString() {
        return "StringResponse{" +
                "result='" + result + '\'' +
                ", base=" + super.toString() +
                '}';
    }
}
