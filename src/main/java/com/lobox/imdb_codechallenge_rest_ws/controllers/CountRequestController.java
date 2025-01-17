package com.lobox.imdb_codechallenge_rest_ws.controllers;

import com.lobox.imdb_codechallenge_rest_ws.services.requests.RequestCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("count")
public class CountRequestController {

    private final RequestCounterService requestCounterService;

    @Autowired
    public CountRequestController(RequestCounterService requestCounterService) {
        this.requestCounterService = requestCounterService;
    }

    @GetMapping("request-count")
    public Integer getCount(){
        return requestCounterService.getRequestCount();
    }
}
