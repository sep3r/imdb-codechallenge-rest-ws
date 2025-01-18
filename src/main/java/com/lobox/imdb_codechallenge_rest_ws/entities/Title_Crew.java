package com.lobox.imdb_codechallenge_rest_ws.entities;


import java.io.Serializable;

public class Title_Crew implements Serializable {
    public String tconst;
    public String directors;
    public String writers;

    public Title_Crew() {
    }

    public Title_Crew(String tconst, String directors, String writers) {
        this.tconst = tconst;
        this.directors = directors;
        this.writers = writers;
    }

    public String getTconst() {
        return tconst;
    }

    public void setTconst(String tconst) {
        this.tconst = tconst;
    }

    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    public String getWriters() {
        return writers;
    }

    public void setWriters(String writers) {
        this.writers = writers;
    }
}
