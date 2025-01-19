package com.lobox.imdb_codechallenge_rest_ws.repositories.titleepisode;

import com.lobox.imdb_codechallenge_rest_ws.entities.Title_Episode;

import java.util.List;

public interface TitleEpisodeRepository {

    List<Title_Episode> getSameDirectorWriterAlive();
}
