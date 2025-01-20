package com.lobox.imdb_codechallenge_rest_ws.services.titleprincipals;

import com.lobox.imdb_codechallenge_rest_ws.entities.Title_Principals;
import com.lobox.imdb_codechallenge_rest_ws.exceptions.ImdbException;
import com.lobox.imdb_codechallenge_rest_ws.repositories.titleprincipals.TitlePrincipalsRepository;
import com.lobox.imdb_codechallenge_rest_ws.repositories.titleprincipals.TitlePrincipalsRepositoryImpl;
import com.lobox.imdb_codechallenge_rest_ws.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TitlePrincipalsServiceImpl extends BaseService implements TitlePrincipalsService {

    private final TitlePrincipalsRepository titlePrincipalsRepository;

    @Autowired
    public TitlePrincipalsServiceImpl(TitlePrincipalsRepositoryImpl titlePrincipalsRepositoryImpl) {
        this.titlePrincipalsRepository = titlePrincipalsRepositoryImpl;
    }

    @Override
    public List<Title_Principals> getListOfPrincipalsByActorId(String actorId) throws ImdbException {
        return titlePrincipalsRepository.getListOfPrincipalsByActorId(actorId);
    }

    @Override
    public Title_Principals getListOfPrincipalsByTitleAndTconst(String actorid, String tConst) throws ImdbException {
        return titlePrincipalsRepository.getListOfPrincipalsByTitleAndTconst(actorid, tConst);
    }
}
