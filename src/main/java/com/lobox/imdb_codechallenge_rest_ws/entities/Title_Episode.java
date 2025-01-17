package com.lobox.imdb_codechallenge_rest_ws.entities;

import java.io.Serializable;

public class Title_Episode implements Serializable {
    public String tconst;
    public String parentTconst;
    public Integer seasonNumber;
    public Integer episodeNumber;

    public Title_Episode() {
    }

    public Title_Episode(String tconst, String parentTconst, Integer seasonNumber, Integer episodeNumber) {
        this.tconst = tconst;
        this.parentTconst = parentTconst;
        this.seasonNumber = seasonNumber;
        this.episodeNumber = episodeNumber;
    }

    public String getTconst() {
        return tconst;
    }

    public void setTconst(String tconst) {
        this.tconst = tconst;
    }

    public String getParentTconst() {
        return parentTconst;
    }

    public void setParentTconst(String parentTconst) {
        this.parentTconst = parentTconst;
    }

    public Integer getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(Integer seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public Integer getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(Integer episodeNumber) {
        this.episodeNumber = episodeNumber;
    }
}
