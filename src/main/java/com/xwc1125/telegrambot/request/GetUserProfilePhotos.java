package com.xwc1125.telegrambot.request;

import com.xwc1125.telegrambot.response.GetUserProfilePhotosResponse;

/**
 * stas
 * 5/2/16.
 */
public class GetUserProfilePhotos extends BaseRequest<GetUserProfilePhotos, GetUserProfilePhotosResponse> {

    public GetUserProfilePhotos(int userId) {
        super(GetUserProfilePhotosResponse.class);
        add("user_id", userId);
    }

    public GetUserProfilePhotos offset(int offset) {
        return add("offset", offset);
    }

    public GetUserProfilePhotos limit(int limit) {
        return add("limit", limit);
    }
}
