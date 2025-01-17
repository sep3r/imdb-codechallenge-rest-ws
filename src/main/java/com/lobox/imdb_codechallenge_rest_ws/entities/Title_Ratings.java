package com.lobox.imdb_codechallenge_rest_ws.entities;

import java.io.Serializable;

public class Title_Ratings implements Serializable {
    public String tconst;
    public Double averageRating;
    public Long numVotes;

    public Title_Ratings() {
    }

    public Title_Ratings(String tconst, Double averageRating, Long numVotes) {
        this.tconst = tconst;
        this.averageRating = averageRating;
        this.numVotes = numVotes;
    }

    public String getTconst() {
        return tconst;
    }

    public void setTconst(String tconst) {
        this.tconst = tconst;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    public Long getNumVotes() {
        return numVotes;
    }

    public void setNumVotes(Long numVotes) {
        this.numVotes = numVotes;
    }
}
