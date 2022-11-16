package com.example.mymovie.controller;

import com.example.mymovie.model.Actor;
import com.example.mymovie.model.ActorAndFilms;
import com.example.mymovie.model.Film;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
@Api(value = "my-movie", description = "Rest APi related to films and actors")
@RestController
public class MyMovieController {
    //generate data with actors and films objects
    public ActorAndFilms data = generator();


    public List<Actor> listOfActors = data.getActors();
    public List<Film> listOfFilms = data.getFilms();



    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })

    @ApiOperation(value = "get all Actors", response = Actor.class, tags = "findActor")
    @RequestMapping(value = "/getAllActors", method = RequestMethod.GET)
    public List getAllActors() {
        int sizeOfList = this.listOfActors.size();
        List returningList = new ArrayList();
        for(int i = 0 ; i<sizeOfList;i++){
            returningList.add(listOfActors.get(i).toString());
        }
        return returningList;
    }
    @ApiOperation(value = "get all Films", response = Film.class, tags = "findFilm")
    @RequestMapping(value = "/getAllFilms", method = RequestMethod.GET)
    public List<String> getAllFilms(){
        int sizeOfList = this.listOfFilms.size();
        List<String> returningList = new ArrayList<>();
        for(int i = 0 ; i<sizeOfList;i++){
            returningList.add(listOfFilms.get(i).toString());
        }
        return returningList;

    }
    @ApiOperation(value = "get Actor with a specified name", response = Actor.class, tags = "findActor")
    @RequestMapping(value = "/findActorByName/{actorByName}", method = RequestMethod.GET)
    public String findActorByName(@PathVariable String actorByName) {
        int sizeOfList = this.listOfActors.size();
        int v = -1;
        for(int i = 0 ; i<sizeOfList;i++){
            if(listOfActors.get(i).getName().equals(actorByName)){
                v = i;
            }
        }
        Actor result= new Actor("null","null","null",null);
        if (v>=0) {
            result = listOfActors.get(v);
        }
        return result.toString();
    }
    @ApiOperation(value = "get Actor with a specified Film title", response = Actor.class, tags = "findActor")
    @RequestMapping(value = "/findActorByFilm/{actorByFilm}", method = RequestMethod.GET)
    public List<String> findActorByFilm(@PathVariable String actorByFilm) {
        int sizeOfList = this.listOfActors.size();
        int v = -1;
        List<String> actorsWithFilm = new ArrayList();
        for(int i = 0 ; i<sizeOfList;i++){
            List<Film> filmListOfTheActor = listOfActors.get(i).getFilmList();
            int sizeOfFilmList = filmListOfTheActor.size();
            for(int u = 0 ; u<sizeOfFilmList;u++){
                if(filmListOfTheActor.get(u).getTitle().equals(actorByFilm)){
                    actorsWithFilm.add(listOfActors.get(i).toString());
                }
            }
        }

        return actorsWithFilm;
    }
    @ApiOperation(value = "get FIlm with a specified title", response = Film.class, tags = "findFilm")
    @RequestMapping(value = "/findFilmByTitle/{filmTitle}", method = RequestMethod.GET)
    public String findFilmByTitle(@PathVariable String filmTitle) {
        int sizeOfList = this.listOfFilms.size();
        int v = -1;
        for(int i = 0 ; i<sizeOfList;i++){
            if(listOfFilms.get(i).getTitle().equals(filmTitle)){
                v = i;
            }
        }
        Film result= new Film("null","null",null,"null");
        if (v>=0) {
            result = listOfFilms.get(v);
        }
        return result.toString();

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
