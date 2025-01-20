package com.lobox.imdb_codechallenge_rest_ws.services.titlebasics;

import com.lobox.imdb_codechallenge_rest_ws.StaticValues;
import com.lobox.imdb_codechallenge_rest_ws.dtos.BestGenreTitleDTO;
import com.lobox.imdb_codechallenge_rest_ws.entities.Title_Basics;
import com.lobox.imdb_codechallenge_rest_ws.exceptions.ImdbException;
import com.lobox.imdb_codechallenge_rest_ws.repositories.titlebasics.TitleBasicsRepository;
import com.lobox.imdb_codechallenge_rest_ws.repositories.titlebasics.TitleBasicsRepositoryImpl;
import com.lobox.imdb_codechallenge_rest_ws.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TitleBasicsServiceImpl extends BaseService implements TitleBasicsService {

    private final TitleBasicsRepository titleBasicsRepository;

    @Autowired
    public TitleBasicsServiceImpl(TitleBasicsRepositoryImpl titleBasicsRepositoryImpl) {
        this.titleBasicsRepository = titleBasicsRepositoryImpl;
    }

    @Override
    public List<BestGenreTitleDTO> getTitleBasicsByGenre(String genre) throws ImdbException {

        List<BestGenreTitleDTO> bestGenreTitleDTOS = null;

        List<Title_Basics> titleBasics = titleBasicsRepository.getTitleBasicsByGenre(genre);
        if (!titleBasics.isEmpty()) {
            titleBasics.sort(Com);
        }else{
            throw new ImdbException(StaticValues.NOTFOUNDDATA, 200);
        }
        return bestGenreTitleDTOS;
    }
}
