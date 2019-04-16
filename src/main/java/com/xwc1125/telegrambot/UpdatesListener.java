package com.xwc1125.telegrambot;

import com.xwc1125.telegrambot.model.Update;

import java.util.List;

/**
 * Stas Parshin
 * 02 November 2016
 */
public interface UpdatesListener {

    int CONFIRMED_UPDATES_ALL = -1;
    int CONFIRMED_UPDATES_NONE = -2;

    int process(List<Update> updates);

}
