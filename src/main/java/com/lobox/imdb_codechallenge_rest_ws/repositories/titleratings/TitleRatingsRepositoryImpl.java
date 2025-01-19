package com.lobox.imdb_codechallenge_rest_ws.repositories.titleratings;

import com.lobox.imdb_codechallenge_rest_ws.repositories.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public class TitleRatingsRepositoryImpl extends BaseRepository implements TitleRatingsRepository {

    private final static String path = "src/main/resources/title.ratings.tsv";
}
