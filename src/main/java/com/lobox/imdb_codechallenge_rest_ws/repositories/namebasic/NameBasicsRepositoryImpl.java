package com.lobox.imdb_codechallenge_rest_ws.repositories.namebasic;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lobox.imdb_codechallenge_rest_ws.entities.Name_Basics;
import com.lobox.imdb_codechallenge_rest_ws.repositories.BaseRepository;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Repository
public class NameBasicsRepositoryImpl extends BaseRepository implements NameBasicsRepository {

    private static final String path = "src/main/resources/name.basics.tsv";
    private static List<String> lines;

    public NameBasicsRepositoryImpl() {
        Path filePath = Paths.get(path);
        try {
            // Read all lines from the file into a list
            lines = Files.readAllLines(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    synchronized public List<Name_Basics> initNameBasics() {
        return List.of();
    }


}
