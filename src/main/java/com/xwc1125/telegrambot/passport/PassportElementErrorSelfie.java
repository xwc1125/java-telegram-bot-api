package com.xwc1125.telegrambot.passport;

/**
 * Stas Parshin
 * 28 August 2018
 */
public class PassportElementErrorSelfie extends PassportElementErrorAbstractFile {
    private final static long serialVersionUID = 0L;

    public PassportElementErrorSelfie(String type, String fileHash, String message) {
        super("selfie", type, fileHash, message);
    }
}
