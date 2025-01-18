package com.lobox.imdb_codechallenge_rest_ws.repositories.titleakas;

import com.lobox.imdb_codechallenge_rest_ws.repositories.BaseRepository;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Repository
public class TitleAkasRepositoryImpl extends BaseRepository implements TitleAkasRepository {

    private static final String path = "src/main/resources/title.akas.tsv";
    private static List<String> lines;

    public TitleAkasRepositoryImpl() {
        Path filePath = Paths.get(path);
        try {
            // Read all lines from the file into a list
            lines = Files.readAllLines(filePath);
            System.out.println("TitleAkasRepositoryImpl");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
