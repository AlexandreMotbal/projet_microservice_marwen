package com.example.mymovie.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

public class Film {
    public Film(String title, String real, Actor mainActor, String date) {
        this.title = title;
        this.real = real;
        this.mainActor = mainActor;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReal() {
        return real;
    }

    public void setReal(String real) {
        this.real = real;
    }

    public Actor getMainActor() {
        return mainActor;
    }

    public void setMainActor(Actor mainActor) {
        this.mainActor = mainActor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", real='" + real + '\'' +
                ", mainActor=" + mainActor.toString() +
                ", date='" + date + '\'' +
                '}';
    }
    /*
    public List<String> stringifyMainActor(){
        int sizeOfList = mainActor.size();
        List<String> returningList = new ArrayList<>();
        for(int i = 0 ; i<sizeOfList;i++) {
            returningList.add(mainActor.get(i).getTitle());
        }
        return returningList;
    }*/
    @ApiModelProperty(notes = "Title of the film",name="title",required=true,value="Test Title")
    public String title;
    @ApiModelProperty(notes = "realisator of the film",name="real",required=true,value="Test real")
    public String real;
    @ApiModelProperty(notes = "Actor of the film",name="mainActor",required=true,value="Test mainActor")
    public Actor mainActor;
    @ApiModelProperty(notes = "Date of the film",name="date",required=true,value="Test date")
    public String date;
}
