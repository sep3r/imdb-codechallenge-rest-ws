package com.lobox.imdb_codechallenge_rest_ws.repositories.namebasic;

import com.lobox.imdb_codechallenge_rest_ws.entities.Name_Basics;
import com.lobox.imdb_codechallenge_rest_ws.repositories.BaseRepository;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Repository
public class NameBasicsRepositoryImpl extends BaseRepository implements NameBasicsRepository {

    private static final String path = "src/main/resources/name.basics.tsv";
    private static List<String> lines;

    public NameBasicsRepositoryImpl() {

    }

    @Override
    synchronized public List<Name_Basics> initNameBasics() {
        try (BufferedReader br = new BufferedReader(new FileReader("path"))) {

            String line;
            while ((line = br.readLine()) != null) {

            }
        } catch (IOException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return null;
    }
}
