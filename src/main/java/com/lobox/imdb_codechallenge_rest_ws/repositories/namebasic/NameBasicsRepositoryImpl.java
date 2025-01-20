package com.lobox.imdb_codechallenge_rest_ws.repositories.namebasic;

import com.lobox.imdb_codechallenge_rest_ws.entities.Name_Basics;
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
public class NameBasicsRepositoryImpl extends BaseRepository implements NameBasicsRepository {

    private static final String path = "src/main/resources/name.basics.tsv";

    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    public synchronized List<Name_Basics> getListCrewPerson(List<Title_Crew> crewList) throws ImdbException {
        List<Name_Basics> nameBasics = null;
        try {
            Resource resource = resourceLoader.getResource("classpath:name.basics.tsv");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
                String line;
                nameBasics = new ArrayList<>();
                while ((line = reader.readLine()) != null) {
                    String[] str = line.split("\t");
                    for (Title_Crew titleCrew : crewList) {
                        if (str[0].trim().contains(titleCrew.getTconst()) && str[3].trim().equals("\\N")) {
                            nameBasics.add(new Name_Basics(str[0],
                                    str[1],
                                    Integer.valueOf(str[2]),
                                    Integer.valueOf(str[3]),
                                    str[4],
                                    str[5]));
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ImdbException(e.getMessage(), 510);
        }
        return nameBasics;
    }

    @Override
    public Name_Basics getNameBasicsByActorName(String actorName) throws ImdbException {
        Name_Basics nameBasics = null;
        try {
            Resource resource = resourceLoader.getResource("classpath:name.basics.tsv");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
                String line;
                nameBasics = new Name_Basics();
                while ((line = reader.readLine()) != null) {
                    String[] str = line.split("\t");
                    if (str[1].trim().equals(actorName)) {
                        nameBasics = new Name_Basics(str[0],
                                str[1],
                                Integer.valueOf(str[2]),
                                Integer.valueOf(str[3]),
                                str[4],
                                str[5]);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ImdbException(e.getMessage(), 510);
        }
        return nameBasics;
    }
}
