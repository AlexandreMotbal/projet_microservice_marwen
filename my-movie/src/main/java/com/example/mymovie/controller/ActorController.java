package com.example.mymovie.controller;

import com.example.mymovie.model.Actor;
import com.example.mymovie.model.Film;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

@RestController
public class ActorController {
    //generate data with actors and films objects
    public List data = generator();
    public List<Actor> listOfActors = (List<Actor>) data.get(0);
    public List<Film> listOfFilms = (List<Film>) data.get(1);

    @RequestMapping(value = "/getAllActors")
    public List<Actor> getAllActors(){
        return this.listOfActors;
    }
    @RequestMapping(value = "/getAllFilms")
    public List<Film> getAllFilms(){
        return this.listOfFilms;
    }

    static List generator(){

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

        ArrayList filmAndActors = new ArrayList<Objects>();
        filmAndActors.add(actorsList);
        filmAndActors.add(filmList);

        return filmAndActors;
    }
}
