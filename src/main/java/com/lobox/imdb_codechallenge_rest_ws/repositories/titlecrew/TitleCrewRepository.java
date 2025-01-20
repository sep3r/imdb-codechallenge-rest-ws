package com.lobox.imdb_codechallenge_rest_ws.repositories.titlecrew;

import com.lobox.imdb_codechallenge_rest_ws.entities.Title_Crew;
import com.lobox.imdb_codechallenge_rest_ws.exceptions.ImdbException;

import java.util.List;

public interface TitleCrewRepository {

    List<Title_Crew> getSameDirectorWriterAlive() throws ImdbException;
}
