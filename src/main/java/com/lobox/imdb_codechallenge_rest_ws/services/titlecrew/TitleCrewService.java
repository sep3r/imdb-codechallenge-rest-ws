package com.lobox.imdb_codechallenge_rest_ws.services.titlecrew;

import com.lobox.imdb_codechallenge_rest_ws.entities.Name_Basics;

import java.util.List;

public interface TitleCrewService {

    List<Name_Basics> getSameDirectorWriterAlive();
}
