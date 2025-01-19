package com.lobox.imdb_codechallenge_rest_ws.repositories.titleepisode;

import com.lobox.imdb_codechallenge_rest_ws.entities.Title_Crew;
import com.lobox.imdb_codechallenge_rest_ws.entities.Title_Episode;
import com.lobox.imdb_codechallenge_rest_ws.repositories.BaseRepository;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TitleEpisodeRepositoryImpl extends BaseRepository implements TitleEpisodeRepository {

    private final static String path = "src/main/resources/title.episode.tsv";
    private static List<String> lines;

    @Override
    public synchronized List<Title_Episode> getSameDirectorWriterAlive() {
        List<Title_Episode> titleCrews = null;
        try (BufferedReader br = new BufferedReader(new FileReader("path"))) {
            String line;
            titleCrews = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                String[] str = line.split("\t");
                if (str[1].trim().contains(str[2].trim())) {
                    //titleCrews.add(new Title_Episode(str[0], str[1], str[2]));
                }
                if (str[2].trim().contains(str[1].trim())) {
                    //titleCrews.add(new Title_Episode(str[0], str[1], str[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return titleCrews;
    }
}
