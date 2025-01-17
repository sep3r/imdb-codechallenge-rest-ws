package com.lobox.imdb_codechallenge_rest_ws.entities;

import java.io.Serializable;

public class Title_Principals implements Serializable {
    public String tconst;
    public String nconst;
    public String category;
    public String job;
    public String characters;

    public Title_Principals() {
    }

    public Title_Principals(String tconst, String nconst, String category, String job, String characters) {
        this.tconst = tconst;
        this.nconst = nconst;
        this.category = category;
        this.job = job;
        this.characters = characters;
    }

    public String getTconst() {
        return tconst;
    }

    public void setTconst(String tconst) {
        this.tconst = tconst;
    }

    public String getNconst() {
        return nconst;
    }

    public void setNconst(String nconst) {
        this.nconst = nconst;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCharacters() {
        return characters;
    }

    public void setCharacters(String characters) {
        this.characters = characters;
    }
}
