package com.lobox.imdb_codechallenge_rest_ws.repositories.namebasic;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lobox.imdb_codechallenge_rest_ws.entities.Name_Basics;
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
public class NameBasicsRepositoryImpl extends BaseRepository implements NameBasicsRepository {

    private static final String path = "src/main/resources/name.basics.tsv";
    private static List<String> lines;

    public NameBasicsRepositoryImpl() {

    }

    @Override
    synchronized public List<Name_Basics> initNameBasics() {
        try (BufferedReader br = new BufferedReader(new FileReader("path"))) {
        }catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
