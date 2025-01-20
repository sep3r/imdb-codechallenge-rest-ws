package com.lobox.imdb_codechallenge_rest_ws.controllers;

import com.lobox.imdb_codechallenge_rest_ws.dtos.BaseDTO;
import com.lobox.imdb_codechallenge_rest_ws.exceptions.ImdbException;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;

public abstract class BaseController {
    protected Logger log = LogManager.getLogger(this.getClass());

    @ExceptionHandler(ImdbException.class)
    public BaseDTO exceptionHandler(ImdbException e, HttpServletResponse response){
        response.setStatus(e.getCode());
        log.error(e.getMessage(),e);
        return new BaseDTO(e.getCode(), e.getMessage());
    }
}
