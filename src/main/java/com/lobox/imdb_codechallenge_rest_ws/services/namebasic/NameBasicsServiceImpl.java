package com.lobox.imdb_codechallenge_rest_ws.services.namebasic;

import com.lobox.imdb_codechallenge_rest_ws.StaticValues;
import com.lobox.imdb_codechallenge_rest_ws.entities.Name_Basics;
import com.lobox.imdb_codechallenge_rest_ws.entities.Title_Crew;
import com.lobox.imdb_codechallenge_rest_ws.entities.Title_Principals;
import com.lobox.imdb_codechallenge_rest_ws.exceptions.ImdbException;
import com.lobox.imdb_codechallenge_rest_ws.repositories.namebasic.NameBasicsRepository;
import com.lobox.imdb_codechallenge_rest_ws.repositories.namebasic.NameBasicsRepositoryImpl;
import com.lobox.imdb_codechallenge_rest_ws.services.BaseService;
import com.lobox.imdb_codechallenge_rest_ws.services.titleprincipals.TitlePrincipalsService;
import com.lobox.imdb_codechallenge_rest_ws.services.titleprincipals.TitlePrincipalsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
public class NameBasicsServiceImpl extends BaseService implements NameBasicsService {

    private final NameBasicsRepository nameBasicsRepository;
    private final TitlePrincipalsService titlePrincipalsService;;

    @Autowired
    public NameBasicsServiceImpl(NameBasicsRepositoryImpl nameBasicsRepositoryImpl, TitlePrincipalsServiceImpl titlePrincipalsServiceImpl) {
        this.nameBasicsRepository = nameBasicsRepositoryImpl;
        this.titlePrincipalsService = titlePrincipalsServiceImpl;
    }

    public List<Name_Basics> getListCrewPerson(List<Title_Crew> crewList) throws ImdbException {
        return nameBasicsRepository.getListCrewPerson(crewList);
    }

    @Override
    public List<Title_Principals> getTitlesByActors(String actorName1, String actorName2) throws ImdbException{
        Name_Basics actor1;
        Name_Basics actor2;
        List<Title_Principals> titlePrincipals = null;
        actor1 = nameBasicsRepository.getNameBasicsByActorName(actorName1);
        if (actor1 != null) {
            actor2 = nameBasicsRepository.getNameBasicsByActorName(actorName2);
            if (actor2 != null) {
                //search actor1
                List<Title_Principals> principals = titlePrincipalsService.getListOfPrincipalsByActorId(actor1.getNconst());
                //here i know actor1 titles now search by actor2 and title id return this
                if (!principals.isEmpty()) {
                    titlePrincipals = new ArrayList<>();
                    for(Title_Principals princ : principals) {
                       Title_Principals titlePrinc = titlePrincipalsService.getListOfPrincipalsByTitleAndTconst(actor2.getNconst(), princ.nconst);
                       if (titlePrinc != null)
                           titlePrincipals.add(titlePrinc);
                    }
                }else {
                    throw new ImdbException(StaticValues.NOTFOUNDACTOR, 511);
                }
            }else {
                throw new ImdbException(StaticValues.NOTFOUNDACTOR, 511);
            }
        }else {
            throw new ImdbException(StaticValues.NOTFOUNDACTOR, 511);
        }
        return titlePrincipals;
    }
}
