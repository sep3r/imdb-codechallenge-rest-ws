package com.lobox.imdb_codechallenge_rest_ws.repositories.titlebasics;

import com.lobox.imdb_codechallenge_rest_ws.repositories.BaseRepository;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Repository
public class TitleBasicsRepositoryImpl extends BaseRepository implements TitleBasicsRepository {

    private static List<String> lines;

    public TitleBasicsRepositoryImpl() {
        Path filePath = Paths.get("src/main/resources/title.basics.tsv");
        try {
            // Read all lines from the file into a list
            lines = Files.readAllLines(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
