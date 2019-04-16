package com.xwc1125.telegrambot.request;

import com.xwc1125.telegrambot.response.BaseResponse;

/**
 * Stas Parshin
 * 26 May 2017
 */
public class AnswerPreCheckoutQuery extends BaseRequest<AnswerPreCheckoutQuery, BaseResponse> {

    public AnswerPreCheckoutQuery(String preCheckoutQueryId) {
        super(BaseResponse.class);
        add("pre_checkout_query_id", preCheckoutQueryId).add("ok", true);
    }

    public AnswerPreCheckoutQuery(String preCheckoutQueryId, String errorMessage) {
        super(BaseResponse.class);
        add("pre_checkout_query_id", preCheckoutQueryId).add("ok", false).add("error_message", errorMessage);
    }
}
