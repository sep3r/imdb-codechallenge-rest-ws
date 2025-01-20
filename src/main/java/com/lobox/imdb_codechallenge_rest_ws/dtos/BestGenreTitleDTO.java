package com.lobox.imdb_codechallenge_rest_ws.dtos;

import com.lobox.imdb_codechallenge_rest_ws.entities.Title_Basics;
import com.lobox.imdb_codechallenge_rest_ws.entities.Title_Ratings;

import java.io.Serializable;

public class BestGenreTitleDTO implements Serializable {

    private Title_Basics title;
    private Title_Ratings ratings;

    public BestGenreTitleDTO() {
    }

    public BestGenreTitleDTO(Title_Basics title, Title_Ratings ratings) {
        this.title = title;
        this.ratings = ratings;
    }

    public Title_Basics getTitle() {
        return title;
    }

    public void setTitle(Title_Basics title) {
        this.title = title;
    }

    public Title_Ratings getRatings() {
        return ratings;
    }

    public void setRatings(Title_Ratings ratings) {
        this.ratings = ratings;
    }
}
