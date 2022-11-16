package com.example.mymovie.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiModelProperty;

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
    @ApiModelProperty(notes = "Name of the actor",name="name",required=true,value="Test name")
    public String name;
    @ApiModelProperty(notes = "FirstName of the actor",name="firstName",required=true,value="Test firstname")
    public String firstNAme;
    @ApiModelProperty(notes = "birth Date of the Actor",name="birthDate",required=true,value="Test birthDate")
    public String birthDate;
    @ApiModelProperty(notes = "Film list of the actor",name="filmList",required=true,value="filmList")
    public List<Film> filmList;
}
