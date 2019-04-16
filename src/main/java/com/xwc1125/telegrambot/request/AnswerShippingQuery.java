package com.xwc1125.telegrambot.request;

import com.xwc1125.telegrambot.model.request.ShippingOption;
import com.xwc1125.telegrambot.response.BaseResponse;

/**
 * Stas Parshin
 * 25 May 2017
 */
public class AnswerShippingQuery extends BaseRequest<AnswerShippingQuery, BaseResponse> {

    public AnswerShippingQuery(String shippingQueryId, ShippingOption... shippingOptions) {
        super(BaseResponse.class);
        add("shipping_query_id", shippingQueryId).add("ok", true).add("shipping_options", serialize(shippingOptions));
    }

    public AnswerShippingQuery(String shippingQueryId, String errorMessage) {
        super(BaseResponse.class);
        add("shipping_query_id", shippingQueryId).add("ok", false).add("error_message", errorMessage);
    }
}
