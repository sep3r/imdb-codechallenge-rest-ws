package com.lobox.imdb_codechallenge_rest_ws.repositories.titleratings;

import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Repository
public class TitleRatingsRepositoryImpl implements TitleRatingsRepository {

    private final static String path = "src/main/resources/title.ratings.tsv";
    private static List<String> lines;

    public TitleRatingsRepositoryImpl() {
        Path filePath = Paths.get(path);
        try {
            // Read all lines from the file into a list
            lines = Files.readAllLines(filePath);
            System.out.println("TitleCrewRepositoryImpl");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
