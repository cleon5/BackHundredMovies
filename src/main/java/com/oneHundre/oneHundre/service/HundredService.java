package com.oneHundre.oneHundre.service;

import com.oneHundre.oneHundre.entity.Actor;
import com.oneHundre.oneHundre.entity.Actores;
import com.oneHundre.oneHundre.entity.Movie;
import com.oneHundre.oneHundre.entity.Saga;

import java.util.List;

public interface HundredService {

    //Movies
    public List<Movie> findAll();
    Movie movieId(int id);
    public void saveMovie(Movie movie);
    void movieDelete(int id);

    //Sagas
    public List<Saga> findSagas();
    Saga sagaId(int id);
    public void saveSaga(Saga saga);
    public void deleteSaga(int id);


    //Actor
    public List<Actores> actoresAll();
    Actor actorId(int id);
    public void saveActor(Actor actor);
    public void deleteActor(int id);

}
