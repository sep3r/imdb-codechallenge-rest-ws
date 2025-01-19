package com.lobox.imdb_codechallenge_rest_ws.repositories.namebasic;

import com.lobox.imdb_codechallenge_rest_ws.entities.Name_Basics;
import com.lobox.imdb_codechallenge_rest_ws.entities.Title_Crew;

import java.util.List;

public interface NameBasicsRepository {

    List<Name_Basics> getListCrewPerson(List<Title_Crew> crewList);
}
