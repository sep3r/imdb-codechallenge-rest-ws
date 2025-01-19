package com.lobox.imdb_codechallenge_rest_ws.controllers;

import com.lobox.imdb_codechallenge_rest_ws.entities.Name_Basics;
import com.lobox.imdb_codechallenge_rest_ws.entities.Title_Crew;
import com.lobox.imdb_codechallenge_rest_ws.entities.Title_Ratings;
import com.lobox.imdb_codechallenge_rest_ws.repositories.BaseRepository;
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

    @Autowired
    public IMDBRequestController(RequestCounterService requestCounterService, TitleCrewServiceImpl titleCrewServiceImpl) {
        this.requestCounterService = requestCounterService;
        this.titleCrewService = titleCrewServiceImpl;
    }

    @GetMapping("request-count")
    public Integer getCount() {
        return requestCounterService.getRequestCount();
    }


    @GetMapping("/equal-director-writer-alive")
    public List<Title_Crew> getEqualDirectorWriterAndlive() {
        return titleCrewService.getSameDirectorWriterAlive();
    }

    @GetMapping("/actors")
    public List<Name_Basics> getTitlesByActors(@RequestParam String actor1, @RequestParam String actor2) {
        return requestCounterService.getTitlesByActors(actor1, actor2);
    }

    @GetMapping("/genre")
    public List<Title_Ratings> getBestTitlesByGenre(@RequestParam String genre) {
        return requestCounterService.getBestTitlesByGenre(genre);
    }
}