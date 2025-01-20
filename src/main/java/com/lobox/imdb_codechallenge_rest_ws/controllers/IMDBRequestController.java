package com.lobox.imdb_codechallenge_rest_ws.controllers;

import com.lobox.imdb_codechallenge_rest_ws.StaticValues;
import com.lobox.imdb_codechallenge_rest_ws.entities.Name_Basics;
import com.lobox.imdb_codechallenge_rest_ws.entities.Title_Principals;
import com.lobox.imdb_codechallenge_rest_ws.entities.Title_Ratings;
import com.lobox.imdb_codechallenge_rest_ws.exceptions.ImdbException;
import com.lobox.imdb_codechallenge_rest_ws.services.namebasic.NameBasicsService;
import com.lobox.imdb_codechallenge_rest_ws.services.namebasic.NameBasicsServiceImpl;
import com.lobox.imdb_codechallenge_rest_ws.services.requests.RequestCounterService;
import com.lobox.imdb_codechallenge_rest_ws.services.titlecrew.TitleCrewService;
import com.lobox.imdb_codechallenge_rest_ws.services.titlecrew.TitleCrewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("count")
public class IMDBRequestController extends BaseController {

    private final RequestCounterService requestCounterService;
    private final TitleCrewService titleCrewService;
    private final NameBasicsService nameBasicsService;

    @Autowired
    public IMDBRequestController(RequestCounterService requestCounterService, TitleCrewServiceImpl titleCrewServiceImpl, NameBasicsServiceImpl nameBasicsServiceImpl) {
        this.requestCounterService = requestCounterService;
        this.titleCrewService = titleCrewServiceImpl;
        this.nameBasicsService = nameBasicsServiceImpl;
    }

    @GetMapping("request-count")
    public Integer getCount() {
        return requestCounterService.getRequestCount();
    }


    @GetMapping("equal-director-writer-alive")
    public List<Name_Basics> getEqualDirectorWriterAndlive() throws ImdbException {
        return titleCrewService.getSameDirectorWriterAlive();
    }

    @GetMapping("actors")
    public List<Title_Principals> getTitlesByActors(@RequestParam String actor1, @RequestParam String actor2) throws ImdbException {
        if(actor1!=null && actor2!=null&&!actor1.equals("")&&!actor2.equals(""))
            return nameBasicsService.getTitlesByActors(actor1, actor2);
        else
            throw new ImdbException(StaticValues.NULLDATASEND, 411);
    }

    @GetMapping("genre")
    public List<Title_Ratings> getBestTitlesByGenre(@RequestParam String genre) throws ImdbException {
        if (genre != null && !genre.equals(""))
        return requestCounterService.getBestTitlesByGenre(genre);
        else
            throw new ImdbException(StaticValues.NULLDATASEND, 411);

    }
}