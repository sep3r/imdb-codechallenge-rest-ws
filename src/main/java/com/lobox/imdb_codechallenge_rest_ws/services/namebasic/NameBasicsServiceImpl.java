package com.lobox.imdb_codechallenge_rest_ws.services.namebasic;

import com.lobox.imdb_codechallenge_rest_ws.StaticValues;
import com.lobox.imdb_codechallenge_rest_ws.entities.Name_Basics;
import com.lobox.imdb_codechallenge_rest_ws.entities.Title_Crew;
import com.lobox.imdb_codechallenge_rest_ws.exceptions.ImdbException;
import com.lobox.imdb_codechallenge_rest_ws.repositories.namebasic.NameBasicsRepository;
import com.lobox.imdb_codechallenge_rest_ws.repositories.namebasic.NameBasicsRepositoryImpl;
import com.lobox.imdb_codechallenge_rest_ws.services.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NameBasicsServiceImpl extends BaseService implements NameBasicsService {

    private final NameBasicsRepository nameBasicsRepository;

    public NameBasicsServiceImpl(NameBasicsRepositoryImpl nameBasicsRepositoryImpl) {
        this.nameBasicsRepository = nameBasicsRepositoryImpl;
    }

    public List<Name_Basics> getListCrewPerson(List<Title_Crew> crewList) throws ImdbException {
        return nameBasicsRepository.getListCrewPerson(crewList);
    }

    @Override
    public Name_Basics getTitlesByActors(String actorName1, String actorName2) throws ImdbException{
        Name_Basics actor1;
        Name_Basics actor2;
        actor1 = nameBasicsRepository.getNameBasicsByActorName(actorName1);
        if (actor1 != null) {
            actor2 = nameBasicsRepository.getNameBasicsByActorName(actorName2);
            if (actor2 != null) {


            }else {
                throw new ImdbException(StaticValues.NOTFOUNDACTOR, 511);
            }
        }else {
            throw new ImdbException(StaticValues.NOTFOUNDACTOR, 511);
        }

    }
}
