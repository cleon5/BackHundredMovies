package com.oneHundre.oneHundre.service;

import com.oneHundre.oneHundre.entity.*;

import java.util.List;

public interface HundredService<T> {

    //Movies
    public List<T> findAll();
    T movieId(int id);
    public void saveMovie(T movie);
    void movieDelete(int id);
    //void saveDisponible(T disponible);

    //Sagas
    public List<T> findSagas();
    T sagaId(int id);
    public void saveSaga(T saga);
    public void deleteSaga(int id);

    //Actor
    public List<T> actoresAll();
    T actorId(int id);
    public void saveActor(T actor);
    public void deleteActor(int id);

    //Director
    public List<T> directorAll();
    T directorId(int id);
    public void saveDirector(T pregunta);
    public void deleteDirector(int id);

    //Disponible
    public List<T> disponibleAll();
    T disponibleId(int id);
    public void saveDisponible(T disponible);
    public void deleteDisponible(int id);

    //Pregunta
    public List<T> preguntaAll();
    T preguntaId(int id);
    public void savePregunta(T pregunta);
    public void deletePregunta(int id);

    //Genero
    public List<T> generoAll();
    T generoId(int id);
    public void saveGenero(T genero);
    public void deleteGenero(int id);
}
