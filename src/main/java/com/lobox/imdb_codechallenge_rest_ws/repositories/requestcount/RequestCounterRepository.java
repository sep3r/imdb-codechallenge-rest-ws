package com.lobox.imdb_codechallenge_rest_ws.repositories.requestcount;

public interface RequestCounterRepository {

    void addRequestCounter();
    Integer getRequestCounter();
}
