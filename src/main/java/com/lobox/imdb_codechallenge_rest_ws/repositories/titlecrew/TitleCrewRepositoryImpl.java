package com.lobox.imdb_codechallenge_rest_ws.repositories.titlecrew;

import com.lobox.imdb_codechallenge_rest_ws.entities.Name_Basics;
import com.lobox.imdb_codechallenge_rest_ws.entities.Title_Crew;
import com.lobox.imdb_codechallenge_rest_ws.repositories.BaseRepository;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TitleCrewRepositoryImpl extends BaseRepository implements TitleCrewRepository {

    private final static String path = "src/main/resources/title.crew.tsv";



    @Override
    synchronized public List<Title_Crew> initNameBasics() {
        List<Title_Crew> titleCrews = null;
        try (BufferedReader br = new BufferedReader(new FileReader("path"))) {
            String line;
            titleCrews = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                String[] str =  line.split("\t");
                if (str[1].trim().contains(str[2].trim())) {
                    titleCrews.add(new Title_Crew(str[0], str[1], str[2]));
                }
                if(str[2].trim().contains(str[1].trim())) {
                    titleCrews.add(new Title_Crew(str[0], str[1], str[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return titleCrews;
    }

}
