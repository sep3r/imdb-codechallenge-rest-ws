package com.lobox.imdb_codechallenge_rest_ws.exceptions;

public class ImdbException extends Exception {

    private Integer code;

    public ImdbException(String message, Integer code) {
        super(message);
        this.code = code;
    }
}
