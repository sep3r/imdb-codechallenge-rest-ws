package com.lobox.imdb_codechallenge_rest_ws.services.namebasic;

import com.lobox.imdb_codechallenge_rest_ws.entities.Name_Basics;
import com.lobox.imdb_codechallenge_rest_ws.entities.Title_Crew;
import com.lobox.imdb_codechallenge_rest_ws.entities.Title_Principals;
import com.lobox.imdb_codechallenge_rest_ws.exceptions.ImdbException;

import java.util.List;

public interface NameBasicsService {

    List<Name_Basics> getListCrewPerson(List<Title_Crew> crewList) throws ImdbException;

    List<Title_Principals> getTitlesByActors(String actorName1, String actorName2) throws ImdbException;
}
