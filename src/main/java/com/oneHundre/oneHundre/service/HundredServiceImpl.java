package com.oneHundre.oneHundre.service;

import com.oneHundre.oneHundre.DAO.HundredGenericsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HundredServiceImpl implements HundredService<Object> {
    @Qualifier("hundredMovieDAOImpl")
    private final HundredGenericsDAO<Object> hundredMovieDAO;
    @Qualifier("hundredSagaDAOImpl")
    private final HundredGenericsDAO<Object> hundredSagaDAO;
    @Qualifier("hundredActorDAOImpl")
    private final HundredGenericsDAO<Object> hundredActorDAO;
    @Qualifier("hundredDisponibleDAOImpl")
    private final HundredGenericsDAO<Object> hundredDisponibleDAO;
    @Qualifier("hundredDirectorDAOImpl")
    private final HundredGenericsDAO<Object> hundredDirectorDAO;
    @Qualifier("hundredGeneroDAOImpl")
    private final HundredGenericsDAO<Object> hundredGeneroDAO;
    @Qualifier("hundredPreguntasDAOImpl")
    private final HundredGenericsDAO<Object> hundredPreguntaDAO;
    @Autowired
    public HundredServiceImpl(@Qualifier("hundredMovieDAOImpl") HundredGenericsDAO<Object> theDAO,
                              @Qualifier("hundredSagaDAOImpl") HundredGenericsDAO<Object> SagaDAO,
                              @Qualifier("hundredActorDAOImpl")HundredGenericsDAO<Object> actorDAO,
                              @Qualifier("hundredDisponibleDAOImpl")HundredGenericsDAO<Object>  disponibleDAO,
                              @Qualifier("hundredGeneroDAOImpl")HundredGenericsDAO<Object>  generoDAO,
                              @Qualifier("hundredPreguntasDAOImpl")HundredGenericsDAO<Object>  preguntasDAO,
                              @Qualifier("hundredDirectorDAOImpl")HundredGenericsDAO<Object>  directorDAO
    ){
        hundredMovieDAO =theDAO;
        hundredSagaDAO = SagaDAO;
        hundredActorDAO = actorDAO;
        hundredDisponibleDAO = disponibleDAO;
        hundredDirectorDAO = directorDAO;
        hundredGeneroDAO = generoDAO;
        hundredPreguntaDAO = preguntasDAO;
    }
    //Movies
    @Override
    @Transactional
    public List<Object> findAll() {
        return hundredMovieDAO.getAll();
    }
    @Override
    @Transactional
    public Object movieId(int id) {
        return hundredMovieDAO.getByID(id);
    }

    @Override
    @Transactional
    public void saveMovie(Object movie) {
        hundredMovieDAO.save(movie);
    }

    @Override
    @Transactional
    public void movieDelete(int id) {
        hundredMovieDAO.delete(id);
    }

    //Sagas
    public List<Object> findSagas() {
        return hundredSagaDAO.getAll();
    }

    @Override
    @Transactional
    public Object sagaId(int id) {
        return hundredSagaDAO.getByID(id);
    }

    @Override
    @Transactional
    public void saveSaga(Object saga) {
        hundredSagaDAO.save(saga);
    }

    @Override
    @Transactional
    public void deleteSaga(int id) {
        hundredSagaDAO.delete(id);
    }

    //Actores
    @Override
    @Transactional
    public List<Object> actoresAll() {
        return hundredActorDAO.getAll();
    }

    @Override
    @Transactional
    public Object actorId(int id) {
        return hundredActorDAO.getByID(id);
    }

    @Override
    @Transactional
    public void saveActor(Object actor) {
        hundredActorDAO.save(actor);
    }

    @Override
    @Transactional
    public void deleteActor(int id) {
        hundredActorDAO.delete(id);
    }

    //Director
    @Override
    @Transactional
    public List<Object> directorAll() {
        return hundredDirectorDAO.getAll();
    }

    @Override
    @Transactional
    public Object directorId(int id) {
        return hundredDirectorDAO.getByID(id);
    }

    @Override
    @Transactional
    public void saveDirector(Object dir) {
        hundredDirectorDAO.save(dir);
    }

    @Override
    @Transactional
    public void deleteDirector(int id) {
        hundredDirectorDAO.delete(id);
    }

    //Disponible
    @Override
    @Transactional
    public List<Object> disponibleAll() {
        return hundredDisponibleDAO.getAll();
    }

    @Override
    @Transactional
    public Object disponibleId(int id) {
        return hundredDisponibleDAO.getByID(id);
    }

    @Override
    public void saveDisponible(Object disponible) {
        hundredDisponibleDAO.save(disponible);
    }

    @Override
    @Transactional
    public void deleteDisponible(int id) {
        hundredDisponibleDAO.delete(id);
    }

    //Preguntas
    @Override
    @Transactional
    public List<Object> preguntaAll() {
        return hundredPreguntaDAO.getAll();
    }

    @Override
    @Transactional
    public Object preguntaId(int id) {
        return hundredPreguntaDAO.getByID(id);
    }

    @Override
    @Transactional
    public void savePregunta(Object pregunta) {
        hundredPreguntaDAO.save(pregunta);
    }

    @Override
    @Transactional
    public void deletePregunta(int id) {
        hundredPreguntaDAO.delete(id);
    }

    @Override
    @Transactional
    public List<Object> generoAll() {
        return hundredGeneroDAO.getAll();
    }

    @Override
    @Transactional
    public Object generoId(int id) {
        return hundredGeneroDAO.getByID(id);
    }

    @Override
    @Transactional
    public void saveGenero(Object genero) {
        hundredGeneroDAO.save(genero);
    }

    @Override
    @Transactional
    public void deleteGenero(int id) {
        hundredGeneroDAO.delete(id);
    }

}
