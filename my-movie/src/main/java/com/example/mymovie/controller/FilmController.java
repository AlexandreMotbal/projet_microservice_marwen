package com.example.mymovie.controller;

import com.example.mymovie.model.Actor;
import com.example.mymovie.model.ActorAndFilms;
import com.example.mymovie.model.Film;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class FilmController {
    //generate data with actors and films objects
    public ActorAndFilms data = generator();


    public List<Actor> listOfActors = data.getActors();
    public List<Film> listOfFilms = data.getFilms();

    @RequestMapping(value = "/getAllFilms", method = RequestMethod.GET)
    public List<String> getAllFilms(){
        int sizeOfList = this.listOfFilms.size();
        List<String> returningList = new ArrayList<>();
        for(int i = 0 ; i<sizeOfList;i++){
            returningList.add(listOfFilms.get(i).toString());
        }
        return returningList;

    }

    static ActorAndFilms generator(){

        Actor danielCraig = new Actor("Craig","daniel","06/09/2000");

        Film skyfall = new Film("skyfall","tarantino",danielCraig,"17/01/2012");
        Film jurrassicPark = new Film("jurrassic park","spielberg",danielCraig,"23/11/2010");

        List<Film> danielFilms = new ArrayList<Film>();
        danielFilms.add(skyfall);
        danielFilms.add(jurrassicPark);
        danielCraig.setFilmList(danielFilms);

        Actor omarSy = new Actor("sy","Omar","06/05/1998");

        Film intouchable = new Film("intouchable","gasper",omarSy,"13/08/2022");
        Film jurrassicWorld = new Film("jurrassic World","spielberg",omarSy,"11/01/2021");

        List<Film> omarSyFilms = new ArrayList<Film>();
        omarSyFilms.add(intouchable);
        omarSyFilms.add(jurrassicWorld);
        omarSy.setFilmList(omarSyFilms);

        List<Actor> actorsList = new ArrayList<>();
        actorsList.add(danielCraig);
        actorsList.add(omarSy);

        List<Film> filmList = new ArrayList<>();
        filmList.add(skyfall);
        filmList.add(jurrassicPark);
        filmList.add(intouchable);
        filmList.add(jurrassicWorld);


        return new ActorAndFilms(actorsList,filmList);

    }
}
