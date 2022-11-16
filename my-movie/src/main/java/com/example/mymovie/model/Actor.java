package com.example.mymovie.model;

import java.util.List;

public class Actor {
    public Actor(String name, String firstNAme, String birthDate, List<Film> filmList) {
        this.name = name;
        this.firstNAme = firstNAme;
        this.birthDate = birthDate;
        this.filmList = filmList;
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

    public String name;
    public String firstNAme;
    public String birthDate;
    public List<Film> filmList;
}
