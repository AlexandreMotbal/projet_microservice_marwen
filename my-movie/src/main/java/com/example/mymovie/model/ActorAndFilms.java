package com.example.mymovie.model;

import java.util.ArrayList;
import java.util.List;

public class ActorAndFilms {
    public ActorAndFilms(List<Actor> actors, List<Film> films) {
        this.actors = actors;
        this.films = films;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public List<Film> getFilms() {
        return films;
    }

    public List<Actor> actors = new ArrayList<>();
    public List<Film> films = new ArrayList<>();

}
