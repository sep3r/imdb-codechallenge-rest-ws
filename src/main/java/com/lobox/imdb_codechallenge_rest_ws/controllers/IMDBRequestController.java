package com.lobox.imdb_codechallenge_rest_ws.controllers;

import com.lobox.imdb_codechallenge_rest_ws.entities.Title_Crew;
import com.lobox.imdb_codechallenge_rest_ws.services.requests.RequestCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("count")
public class IMDBRequestController {

    private final RequestCounterService requestCounterService;

    @Autowired
    public IMDBRequestController(RequestCounterService requestCounterService) {
        this.requestCounterService = requestCounterService;
    }

    @GetMapping("request-count")
    public Integer getCount() {
        return requestCounterService.getRequestCount();
    }


    @GetMapping("/same-director-writer")
    public List<Title_Crew> getSameDirectorWriterAlive() {
        return movieService.getSameDirectorWriterAlive();
    }

    @GetMapping("/actors")
    public List<Title_Crew> getTitlesByActors(@RequestParam String actor1, @RequestParam String actor2) {
        return movieService.getTitlesByActors(actor1, actor2);
    }

    @GetMapping("/genre")
    public List<Title_Crew> getBestTitlesByGenre(@RequestParam String genre) {
        return movieService.getBestTitlesByGenre(genre);
    }
}