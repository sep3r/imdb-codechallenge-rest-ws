package com.lobox.imdb_codechallenge_rest_ws.services.titleprincipals;

import com.lobox.imdb_codechallenge_rest_ws.entities.Title_Principals;
import com.lobox.imdb_codechallenge_rest_ws.exceptions.ImdbException;

import java.util.List;

public interface TitlePrincipalsService {

    List<Title_Principals> getListOfPrincipalsByActorId(String actorId) throws ImdbException;
    Title_Principals getListOfPrincipalsByTitleAndTconst(String actorid , String tConst) throws ImdbException;
}
