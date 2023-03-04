package com.oneHundre.oneHundre.DAO;

import com.oneHundre.oneHundre.entity.Movie;
import com.oneHundre.oneHundre.entity.Saga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;
@Repository
public class HundredMovieDAOImpl implements HundredMovieDAO {
    private EntityManager entityManager;
    @Autowired
    public HundredMovieDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Movie> allMovie() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Movie> theQuery = currentSession.createQuery("from Movie", Movie.class);
        List<Movie> movie = theQuery.getResultList();

        return movie;
    }
    @Override
    public void saveMovie(Movie movie) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(movie);
    }
    @Override
    public Movie movieId(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Movie movie = currentSession.get(Movie.class, id);
        return movie;
    }
    @Override
    public void deleteMovie(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<?> theQuery = currentSession.createQuery("delete from Movie where id=:Id");
        theQuery.setParameter("Id", id);

        theQuery.executeUpdate();
    }
}