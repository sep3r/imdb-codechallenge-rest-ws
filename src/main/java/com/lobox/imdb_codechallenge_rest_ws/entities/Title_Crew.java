package com.lobox.imdb_codechallenge_rest_ws.entities;

import java.io.Serializable;
import java.util.Set;

public class Title_Crew implements Serializable {
    public String tconst;
    public Set<String> directors;
    public Set<String> writers;

    public Title_Crew() {
    }

    public Title_Crew(String tconst, Set<String> directors, Set<String> writers) {
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

    public Set<String> getDirectors() {
        return directors;
    }

    public void setDirectors(Set<String> directors) {
        this.directors = directors;
    }

    public Set<String> getWriters() {
        return writers;
    }

    public void setWriters(Set<String> writers) {
        this.writers = writers;
    }
}
