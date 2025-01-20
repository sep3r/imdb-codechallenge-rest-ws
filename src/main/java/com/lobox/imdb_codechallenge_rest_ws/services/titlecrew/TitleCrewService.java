package com.lobox.imdb_codechallenge_rest_ws.services.titlecrew;

import com.lobox.imdb_codechallenge_rest_ws.entities.Name_Basics;
import com.lobox.imdb_codechallenge_rest_ws.exceptions.ImdbException;

import java.util.List;

public interface TitleCrewService {

    List<Name_Basics> getSameDirectorWriterAlive() throws ImdbException;
}
