package com.lobox.imdb_codechallenge_rest_ws.repositories.titleakas;

import com.lobox.imdb_codechallenge_rest_ws.entities.Name_Basics;
import com.lobox.imdb_codechallenge_rest_ws.entities.Title_Akas;
import com.lobox.imdb_codechallenge_rest_ws.repositories.BaseRepository;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Repository
public class TitleAkasRepositoryImpl extends BaseRepository implements TitleAkasRepository {

    private static final String path = "src/main/resources/title.akas.tsv";

    @Override
    public synchronized List<Title_Akas> getsom() {
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
