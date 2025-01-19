package com.lobox.imdb_codechallenge_rest_ws.repositories.titleprincipals;

import com.lobox.imdb_codechallenge_rest_ws.repositories.BaseRepository;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Repository
public class TitlePrincipalsRepositoryImpl extends BaseRepository implements TitlePrincipalsRepository {

    private final static String path = "src/main/resources/title.principals.tsv";
    private static List<String> lines;

    public TitlePrincipalsRepositoryImpl() {
        Path filePath = Paths.get(path);
        try {
            // Read all lines from the file into a list
            lines = Files.readAllLines(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
