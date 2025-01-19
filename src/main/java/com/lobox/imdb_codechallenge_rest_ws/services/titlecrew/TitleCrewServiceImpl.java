package com.lobox.imdb_codechallenge_rest_ws.services.titlecrew;

import com.lobox.imdb_codechallenge_rest_ws.entities.Title_Crew;
import com.lobox.imdb_codechallenge_rest_ws.repositories.titlecrew.TitleCrewRepository;
import com.lobox.imdb_codechallenge_rest_ws.repositories.titlecrew.TitleCrewRepositoryImpl;
import com.lobox.imdb_codechallenge_rest_ws.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TitleCrewServiceImpl extends BaseService implements TitleCrewService {

    private final TitleCrewRepository titleCrewRepository;

    @Autowired
    public TitleCrewServiceImpl(TitleCrewRepositoryImpl titleCrewRepositoryImpl) {
        this.titleCrewRepository = titleCrewRepositoryImpl;
    }

    public List<Title_Crew> getSameDirectorWriterAlive() {
        List<Title_Crew> titleCrews = titleCrewRepository.getSameDirectorWriterAlive();
        return null;
    }
}
