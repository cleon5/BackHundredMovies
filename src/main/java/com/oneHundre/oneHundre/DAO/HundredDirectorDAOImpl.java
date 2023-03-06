package com.oneHundre.oneHundre.DAO;

import com.oneHundre.oneHundre.entity.Director;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class HundredDirectorDAOImpl implements HundredGenericsDAO {
    private final EntityManager entityManager;
    @Autowired
    public HundredDirectorDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    public List getAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<?> theQuery = currentSession.createQuery("from Director", Director.class);
        return theQuery.getResultList();
    }

    @Override
    public Object getByID(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Director.class, id);
    }

    @Override
    public void save(Object o) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(o);
    }

    @Override
    public void delete(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<?> theQuery = currentSession.createQuery("delete from Director where id=:Id");
        theQuery.setParameter("Id", id);

        theQuery.executeUpdate();
    }
}
