package com.lobox.imdb_codechallenge_rest_ws.dtos;

public class BaseDTO<T> {

    private Integer errorId;
    private String errorMessage;
    private T t;
}