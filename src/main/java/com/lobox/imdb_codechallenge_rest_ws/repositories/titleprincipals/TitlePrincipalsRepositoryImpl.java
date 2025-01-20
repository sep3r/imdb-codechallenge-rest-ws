package com.lobox.imdb_codechallenge_rest_ws.repositories.titleprincipals;

import com.lobox.imdb_codechallenge_rest_ws.entities.Title_Principals;
import com.lobox.imdb_codechallenge_rest_ws.exceptions.ImdbException;
import com.lobox.imdb_codechallenge_rest_ws.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TitlePrincipalsRepositoryImpl extends BaseRepository implements TitlePrincipalsRepository {

    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    public List<Title_Principals> getListOfPrincipalsByActorId(String actorId) throws ImdbException {
        List<Title_Principals> titlePrincipals = null;
        try {
            Resource resource = resourceLoader.getResource("classpath:title.principals.tsv");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
                String line;
                titlePrincipals = new ArrayList<>();
                while ((line = reader.readLine()) != null) {
                    String[] str = line.split("\t");
                    if (str[2].equals(actorId) && str[3].equals("actor")) {
                        titlePrincipals.add(new Title_Principals(str[0],
                                str[1],
                                str[2],
                                str[3],
                                str[4]));
                    }
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw new ImdbException(e.getMessage(), 501);
        }
        return titlePrincipals;
    }

    public Title_Principals getListOfPrincipalsByTitleAndTconst(String actorid, String tConst) throws ImdbException {
        Title_Principals titlePrincipals = null;
        try {
            Resource resource = resourceLoader.getResource("classpath:title.principals.tsv");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
                String line;

                while ((line = reader.readLine()) != null) {
                    String[] str = line.split("\t");
                    if (str[0].equals(tConst) && str[2].equals(actorid) && str[3].equals("actor")) {
                        titlePrincipals = new Title_Principals(str[0],
                                str[1],
                                str[2],
                                str[3],
                                str[4]);
                    }
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw new ImdbException(e.getMessage(), 501);
        }
        return titlePrincipals;
    }
}
