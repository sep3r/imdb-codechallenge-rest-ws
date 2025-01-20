package com.lobox.imdb_codechallenge_rest_ws.repositories.titlebasics;

import com.lobox.imdb_codechallenge_rest_ws.entities.Title_Basics;
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
public class TitleBasicsRepositoryImpl extends BaseRepository implements TitleBasicsRepository {

    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    public List<Title_Basics> getTitleBasicsByGenre(String genre) throws ImdbException {
        List<Title_Basics> titleBasics = null;
        try {
            Resource resource = resourceLoader.getResource("classpath:title.basics.tsv");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
                String line;
                titleBasics = new ArrayList<>();
                while ((line = reader.readLine()) != null) {
                    String[] str = line.split("\t");
                    if (str[8].contains(genre)) {
                        titleBasics.add(new Title_Basics(str[0],
                                str[1],
                                str[2],
                                str[3],
                                str[4].equals("1"),
                                Integer.valueOf(str[5]),
                                Integer.valueOf(str[6]),
                                Integer.valueOf(str[7]),
                                str[8]));
                    }
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw new ImdbException(e.getMessage(), 510);
        }
        return titleBasics;
    }
}
