package com.oneHundre.oneHundre.service;

import com.oneHundre.oneHundre.DAO.HundredActorDAO;
import com.oneHundre.oneHundre.DAO.HundredMovieDAO;
import com.oneHundre.oneHundre.DAO.HundredMovieDAOImpl;
import com.oneHundre.oneHundre.DAO.HundredSagaDAO;
import com.oneHundre.oneHundre.entity.Actor;
import com.oneHundre.oneHundre.entity.Actores;
import com.oneHundre.oneHundre.entity.Movie;
import com.oneHundre.oneHundre.entity.Saga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HundredServiceImpl implements HundredService{
    private HundredMovieDAO hundredMovieDAO;
    private HundredSagaDAO hundredSagaDAO;
    private HundredActorDAO hundredActorDAO;
    @Autowired
    public HundredServiceImpl(HundredMovieDAO theDAO, HundredSagaDAO SagaDAO, HundredActorDAO actorDAO){
        hundredMovieDAO =theDAO;
        hundredSagaDAO = SagaDAO;
        hundredActorDAO = actorDAO;
    }
    //Movies
    @Override
    @Transactional
    public List<Movie> findAll() {
        return hundredMovieDAO.allMovie();
    }
    @Override
    @Transactional
    public Movie movieId(int id) {
        return hundredMovieDAO.movieId(id);
    }

    @Override
    @Transactional
    public void saveMovie(Movie movie) {
        hundredMovieDAO.saveMovie(movie);
    }

    @Override
    @Transactional
    public void movieDelete(int id) {
        hundredMovieDAO.deleteMovie(id);
    }

    //Sagas
    public List<Saga> findSagas() {
        return hundredSagaDAO.allSaga();
    }

    @Override
    @Transactional
    public Saga sagaId(int id) {
        return hundredSagaDAO.sagaId(id);
    }

    @Override
    @Transactional
    public void saveSaga(Saga saga) {
        hundredSagaDAO.saveSaga(saga);
    }

    @Override
    @Transactional
    public void deleteSaga(int id) {
        hundredSagaDAO.deleteSaga(id);
    }

    //Actores
    @Override
    @Transactional
    public List<Actores> actoresAll() {
        return hundredActorDAO.allActor();
    }

    @Override
    @Transactional
    public Actor actorId(int id) {
        return hundredActorDAO.actorId(id);
    }

    @Override
    @Transactional
    public void saveActor(Actor actor) {
        hundredActorDAO.saveActor(actor);
    }

    @Override
    @Transactional
    public void deleteActor(int id) {
        hundredActorDAO.deleteActor(id);
    }

}
