package com.lobox.imdb_codechallenge_rest_ws.repositories.requestcount;

import com.lobox.imdb_codechallenge_rest_ws.entities.RequestCount;
import com.lobox.imdb_codechallenge_rest_ws.repositories.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public class RequestCountRepositoryImpl implements RequestCounterRepository{

    private RequestCount requestCount = new RequestCount();

    @Override
    public void addRequestCount() {
        requestCount.addCount();
    }

    @Override
    public Integer getRequestCount() {
        return requestCount.getCount();
    }
}
