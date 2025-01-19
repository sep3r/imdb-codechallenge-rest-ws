package com.lobox.imdb_codechallenge_rest_ws.dtos;

import java.util.List;

public class ListDto<E> {

    private Integer errorId;
    private String errorMessage;
    private List<E> list;
}
