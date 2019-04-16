package com.xwc1125.telegrambot.request;

import com.xwc1125.telegrambot.response.GetUpdatesResponse;

/**
 * stas
 * 5/2/16.
 */
public class GetUpdates extends BaseRequest<GetUpdates, GetUpdatesResponse> {

    private int timeout = 0;
    private int limit = 100;

    public GetUpdates() {
        super(GetUpdatesResponse.class);
    }

    public GetUpdates offset(int offset) {
        return add("offset", offset);
    }

    public GetUpdates limit(int limit) {
        this.limit = limit;
        return add("limit", limit);
    }

    public GetUpdates timeout(int timeout) {
        this.timeout = timeout;
        return add("timeout", timeout);
    }

    public GetUpdates allowedUpdates(String... allowedUpdates) {
        return add("allowed_updates", serialize(allowedUpdates));
    }

    @Override
    public int getTimeoutSeconds() {
        return timeout;
    }

    public int getLimit() {
        return limit;
    }
}
