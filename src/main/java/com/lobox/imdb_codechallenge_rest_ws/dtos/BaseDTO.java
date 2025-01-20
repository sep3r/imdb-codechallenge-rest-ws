package com.lobox.imdb_codechallenge_rest_ws.dtos;

public class BaseDTO<T> {

    private Integer errorId;
    private String errorMessage;
    private T t;

    public BaseDTO(Integer errorId, String errorMessage, T t) {
        this.errorId = errorId;
        this.errorMessage = errorMessage;
        this.t = t;
    }

    public BaseDTO(Integer errorId, String errorMessage) {
        this.errorId = errorId;
        this.errorMessage = errorMessage;
    }

    public Integer getErrorId() {
        return errorId;
    }

    public void setErrorId(Integer errorId) {
        this.errorId = errorId;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}