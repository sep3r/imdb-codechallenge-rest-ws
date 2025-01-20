package com.lobox.imdb_codechallenge_rest_ws.services.titlebasics;

import com.lobox.imdb_codechallenge_rest_ws.dtos.BestGenreTitleDTO;
import com.lobox.imdb_codechallenge_rest_ws.entities.Title_Basics;
import com.lobox.imdb_codechallenge_rest_ws.exceptions.ImdbException;

import java.util.List;

public interface TitleBasicsService {

    List<BestGenreTitleDTO> getTitleBasicsByGenre(String genre) throws ImdbException;
}
