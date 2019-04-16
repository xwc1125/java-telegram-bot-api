package com.xwc1125.telegrambot.request;

/**
 * Stas Parshin
 * 03 October 2016
 */
public class SendGame extends AbstractSendRequest<SendGame> {

    public SendGame(Object chatId, String gameShortName) {
        super(chatId);
        add("game_short_name", gameShortName);
    }

}
