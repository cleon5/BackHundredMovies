package com.oneHundre.oneHundre.DAO;

import com.oneHundre.oneHundre.entity.Disponible;
import com.oneHundre.oneHundre.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;
@Repository
public class HundredMovieDAOImpl implements HundredGenericsDAO {
    private final EntityManager entityManager;
    @Autowired
    public HundredMovieDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List getAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Movie> theQuery = currentSession.createQuery("from Movie", Movie.class);
        return theQuery.getResultList();
    }
    @Override
    public void save(Object o) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(o);
    }
    @Override
    public Object getByID(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Movie.class, id);
    }
    @Override
    public void delete(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<?> theQuery = currentSession.createQuery("delete from Movie where id=:Id");
        theQuery.setParameter("Id", id);

        theQuery.executeUpdate();
    }

    //@Override
    public void saveDisponible(Disponible disponible) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(disponible);
    }
}