package com.lobox.imdb_codechallenge_rest_ws.repositories.titlecrew;

import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Repository
public class TitleCrewRepositoryImpl implements TitleCrewRepository {

    private final static String path = "src/main/resources/title.crew.tsv";
    private static List<String> lines;

    public TitleCrewRepositoryImpl() {
        Path filePath = Paths.get(path);
        try {
            // Read all lines from the file into a list
            lines = Files.readAllLines(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
