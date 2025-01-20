package com.lobox.imdb_codechallenge_rest_ws.repositories.titlecrew;

import com.lobox.imdb_codechallenge_rest_ws.entities.Title_Crew;
import com.lobox.imdb_codechallenge_rest_ws.exceptions.ImdbException;
import com.lobox.imdb_codechallenge_rest_ws.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TitleCrewRepositoryImpl extends BaseRepository implements TitleCrewRepository {

    private final static String path = "src/main/resources/title.crew.tsv";

    @Autowired
    private ResourceLoader resourceLoader;


    @Override
    public synchronized List<Title_Crew> getSameDirectorWriterAlive() throws ImdbException {
        List<Title_Crew> titleCrews = null;
        try {
            Resource resource = resourceLoader.getResource("classpath:title.crew.tsv");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
                String line;
                titleCrews = new ArrayList<>();
                while ((line = reader.readLine()) != null) {
                    String[] str = line.split("\t");
                    if (str[1].trim().contains(str[2].trim()) || str[2].trim().contains(str[1].trim())) {
                        titleCrews.add(new Title_Crew(str[0], str[1], str[2]));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ImdbException(e.getMessage(), 510);
        }
        return titleCrews;
    }
}
