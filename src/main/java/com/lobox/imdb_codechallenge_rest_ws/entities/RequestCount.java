package com.lobox.imdb_codechallenge_rest_ws.entities;

import java.io.Serializable;

public class RequestCount implements Serializable {

    private static Integer counter;

    public RequestCount() {
        counter = 0;
    }

    public synchronized void addCount(){
        counter++;
    }

    public synchronized Integer getCount(){
        return counter;
    }
}
