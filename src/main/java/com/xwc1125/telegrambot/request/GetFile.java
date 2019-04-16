package com.xwc1125.telegrambot.request;

import com.xwc1125.telegrambot.response.GetFileResponse;

/**
 * stas
 * 5/1/16.
 */
public class GetFile extends BaseRequest<GetFile, GetFileResponse> {

    public GetFile(String fileId) {
        super(GetFileResponse.class);
        add("file_id", fileId);
    }
}
