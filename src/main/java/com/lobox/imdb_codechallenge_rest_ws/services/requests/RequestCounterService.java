package com.lobox.imdb_codechallenge_rest_ws.services.requests;

import com.lobox.imdb_codechallenge_rest_ws.entities.Name_Basics;
import com.lobox.imdb_codechallenge_rest_ws.entities.Title_Crew;
import com.lobox.imdb_codechallenge_rest_ws.entities.Title_Ratings;

import java.util.List;

public interface RequestCounterService {

    Integer getRequestCount();

    void setRequestCount();

    List<Name_Basics> getTitlesByActors(String actor1, String actor2);

    List<Title_Ratings> getBestTitlesByGenre(String genre);
}
