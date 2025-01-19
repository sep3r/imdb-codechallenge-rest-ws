package com.lobox.imdb_codechallenge_rest_ws.aop;

import com.lobox.imdb_codechallenge_rest_ws.services.requests.RequestCounterService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class RequestCounterAOP {

    private final Logger log = Logger.getLogger(this.getClass().getName());
    private final RequestCounterService requestCounterService;

    public RequestCounterAOP(RequestCounterService requestCounterService) {
        this.requestCounterService = requestCounterService;
    }

    @Before("execution(* com.lobox.imdb_codechallenge_rest_ws.controllers.*.*(..))")
    public void logNamaMethodUsage(JoinPoint joinPoint) {
        try {
            requestCounterService.setRequestCount();
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }
}
