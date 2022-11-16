package com.example.mymovie.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class Actor {
    public Actor(String name, String firstNAme, String birthDate, List<Film> filmList) {
        this.name = name;
        this.firstNAme = firstNAme;
        this.birthDate = birthDate;
        this.filmList = filmList;
    }
    public Actor(String name, String firstNAme, String birthDate) {
        this.name = name;
        this.firstNAme = firstNAme;
        this.birthDate = birthDate;
        this.filmList = null;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstNAme() {
        return firstNAme;
    }

    public void setFirstNAme(String firstNAme) {
        this.firstNAme = firstNAme;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public List<Film> getFilmList() {
        return filmList;
    }

    public void setFilmList(List<Film> filmList) {
        this.filmList = filmList;
    }

    @Override
    public String toString() {

            return "Actor{" +
                    "name='" + name + '\'' +
                    ", firstNAme='" + firstNAme + '\'' +
                    ", birthDate='" + birthDate + '\'' +
                    ", filmList=" + listFilmName() +
                    '}';

    }
    public List<String>listFilmName(){
        int sizeOfList = filmList.size();
        List returningList = new ArrayList();
        for(int i = 0 ; i<sizeOfList;i++) {
            returningList.add(filmList.get(i).getTitle());
        }
        return returningList;
    }
    public String name;
    public String firstNAme;
    public String birthDate;
    public List<Film> filmList;
}
