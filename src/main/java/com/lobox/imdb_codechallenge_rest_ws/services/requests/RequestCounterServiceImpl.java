package com.lobox.imdb_codechallenge_rest_ws.services.requests;

import com.lobox.imdb_codechallenge_rest_ws.repositories.namebasic.NameBasicsRepository;
import com.lobox.imdb_codechallenge_rest_ws.repositories.namebasic.NameBasicsRepositoryImpl;
import com.lobox.imdb_codechallenge_rest_ws.repositories.requestcount.RequestCounterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestCounterServiceImpl implements RequestCounterService {

    private final RequestCounterRepository requestCounterRepository;

    @Autowired
    public RequestCounterServiceImpl(RequestCounterRepository requestCounterRepository) {
        this.requestCounterRepository = requestCounterRepository;
    }

    @Override
    public Integer getRequestCount() {
        return requestCounterRepository.getRequestCount();
    }

    @Override
    public void setRequestCount() {
        requestCounterRepository.addRequestCount();
    }


}
