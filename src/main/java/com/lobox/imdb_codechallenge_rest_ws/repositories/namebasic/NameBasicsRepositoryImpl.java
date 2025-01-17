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

    private static List<Name_Basics> nameBasics;

    public NameBasicsRepositoryImpl() {
        nameBasics = new ArrayList<>();
        Path filePath = Paths.get("src/main/resources/name.basics.tsv");
        List<String> lines = null;

        /*String query = "       CREATE TABLE IF NOT EXISTS TBL_Name_Basics (NCONST VARCHAR(100) PRIMARY KEY , \n"
                + "            PRIMARYNAME VARCHAR(100),\n"
                + "            BIRTHYEAR  Number(25),\n"
                + "            DEATHYEAR  VARCHAR(100),\n"
                + "            ENODEB_ID  VARCHAR(50),\n"
                + "            CELL_TYPE  VARCHAR(255),\n"
                + "            LOCATION VARCHAR(50),\n"
                + "            LATITUDE  VARCHAR(25),\n"
                + "            LONGITUDE  VARCHAR(25),\n"
                + "            REGION  VARCHAR(25),\n"
                + "            PROVINCE  VARCHAR(50),\n"
                + "            CITY  VARCHAR(50),\n"
                + "            ADDRESS  VARCHAR(255),\n"
                + "            PARENT  VARCHAR(25));";
        System.out.println(query);
    } catch (NullPointerException e) {
        e.printStackTrace();
    }*/


        try {
            // Read all lines from the file into a list
            lines = Files.readAllLines(filePath);
            // Print each line
            Name_Basics basics = null;
            for (int i = 1; i < lines.size(); i++) {
                String[] recordArray = lines.get(i).split("\t");
                basics = new Name_Basics();
                basics.setNconst(recordArray[0].trim());
                basics.setPrimaryName(recordArray[1]);
                basics.setBirthYear(Integer.valueOf(recordArray[2].equals("\\N") ? "0" : recordArray[2]));
                basics.setDeathYear(Integer.valueOf(recordArray[3].equals("\\N") ? "0" : recordArray[3]));
                basics.setPrimaryProfession(recordArray[4].split(","));
                basics.setKnownForTitles(recordArray[5].split(","));
                nameBasics.add(basics);
                System.out.println(nameBasics.size());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    synchronized public List<Name_Basics> initNameBasics() {
        return List.of();
    }


}
