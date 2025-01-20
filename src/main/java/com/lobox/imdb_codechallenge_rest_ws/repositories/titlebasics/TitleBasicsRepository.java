package com.lobox.imdb_codechallenge_rest_ws.repositories.titlebasics;

import com.lobox.imdb_codechallenge_rest_ws.entities.Title_Basics;
import com.lobox.imdb_codechallenge_rest_ws.exceptions.ImdbException;

import java.util.List;

public interface TitleBasicsRepository {

    List<Title_Basics> getTitleBasicsByGenre(String genre) throws ImdbException;
}
