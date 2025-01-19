package com.lobox.imdb_codechallenge_rest_ws.services.requests;

import com.lobox.imdb_codechallenge_rest_ws.entities.Name_Basics;
import com.lobox.imdb_codechallenge_rest_ws.entities.Title_Crew;
import com.lobox.imdb_codechallenge_rest_ws.entities.Title_Ratings;
import com.lobox.imdb_codechallenge_rest_ws.repositories.namebasic.NameBasicsRepository;
import com.lobox.imdb_codechallenge_rest_ws.repositories.namebasic.NameBasicsRepositoryImpl;
import com.lobox.imdb_codechallenge_rest_ws.repositories.requestcount.RequestCounterRepository;
import com.lobox.imdb_codechallenge_rest_ws.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestCounterServiceImpl extends BaseService implements RequestCounterService {

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

    @Override
    public List<Name_Basics> getTitlesByActors(String actor1, String actor2) {
        return List.of();
    }

    @Override
    public List<Title_Ratings> getBestTitlesByGenre(String genre) {
        return List.of();
    }


}
