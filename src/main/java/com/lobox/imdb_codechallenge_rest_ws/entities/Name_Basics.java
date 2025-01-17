package com.lobox.imdb_codechallenge_rest_ws.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class Name_Basics implements Serializable {
    public String nconst;
    public String primaryName;
    public Integer birthYear;
    public Integer deathYear;
    public Set<String> primaryProfession;
    public List<String> knownForTitles;

    public Name_Basics() {
    }

    public Name_Basics(String nconst, String primaryName, Integer birthYear, Integer deathYear, Set<String> primaryProfession, List<String> knownForTitles) {
        this.nconst = nconst;
        this.primaryName = primaryName;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
        this.primaryProfession = primaryProfession;
        this.knownForTitles = knownForTitles;
    }

    public String getNconst() {
        return nconst;
    }

    public void setNconst(String nconst) {
        this.nconst = nconst;
    }

    public String getPrimaryName() {
        return primaryName;
    }

    public void setPrimaryName(String primaryName) {
        this.primaryName = primaryName;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
    }

    public Set<String> getPrimaryProfession() {
        return primaryProfession;
    }

    public void setPrimaryProfession(Set<String> primaryProfession) {
        this.primaryProfession = primaryProfession;
    }

    public List<String> getKnownForTitles() {
        return knownForTitles;
    }

    public void setKnownForTitles(List<String> knownForTitles) {
        this.knownForTitles = knownForTitles;
    }
}
