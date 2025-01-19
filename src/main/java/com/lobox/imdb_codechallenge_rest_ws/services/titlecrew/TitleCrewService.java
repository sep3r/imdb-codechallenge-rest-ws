package com.lobox.imdb_codechallenge_rest_ws.services.titlecrew;

import com.lobox.imdb_codechallenge_rest_ws.entities.Title_Crew;

import java.util.List;

public interface TitleCrewService {

    List<Title_Crew> getSameDirectorWriterAlive();
}
