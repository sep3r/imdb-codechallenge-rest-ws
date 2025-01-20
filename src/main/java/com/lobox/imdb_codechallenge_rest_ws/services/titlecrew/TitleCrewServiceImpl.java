package com.lobox.imdb_codechallenge_rest_ws.services.titlecrew;

import com.lobox.imdb_codechallenge_rest_ws.entities.Name_Basics;
import com.lobox.imdb_codechallenge_rest_ws.entities.Title_Crew;
import com.lobox.imdb_codechallenge_rest_ws.exceptions.ImdbException;
import com.lobox.imdb_codechallenge_rest_ws.repositories.titlecrew.TitleCrewRepository;
import com.lobox.imdb_codechallenge_rest_ws.repositories.titlecrew.TitleCrewRepositoryImpl;
import com.lobox.imdb_codechallenge_rest_ws.services.BaseService;
import com.lobox.imdb_codechallenge_rest_ws.services.namebasic.NameBasicsService;
import com.lobox.imdb_codechallenge_rest_ws.services.namebasic.NameBasicsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TitleCrewServiceImpl extends BaseService implements TitleCrewService {

    private final TitleCrewRepository titleCrewRepository;
    private final NameBasicsService nameBasicsService;

    @Autowired
    public TitleCrewServiceImpl(TitleCrewRepositoryImpl titleCrewRepositoryImpl, NameBasicsServiceImpl nameBasicsServiceImpl) {
        this.titleCrewRepository = titleCrewRepositoryImpl;
        this.nameBasicsService = nameBasicsServiceImpl;
    }

    /*
     * I need to implement search Algorithm such as binary or BST but my memory does not support this capacity files
     * */
    public List<Name_Basics> getSameDirectorWriterAlive() throws ImdbException {
        List<Name_Basics> nameBasics = null;
        List<Title_Crew> titleCrews = titleCrewRepository.getSameDirectorWriterAlive();
        if (!titleCrews.isEmpty())
            nameBasics = nameBasicsService.getListCrewPerson(titleCrews);
        return nameBasics;
    }
}
