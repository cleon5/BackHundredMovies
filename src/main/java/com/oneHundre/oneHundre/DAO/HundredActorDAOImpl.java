package com.oneHundre.oneHundre.DAO;

import com.oneHundre.oneHundre.entity.Actor;
import com.oneHundre.oneHundre.entity.Actores;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class HundredActorDAOImpl implements HundredGenericsDAO {
    private final EntityManager entityManager;
    @Autowired
    public HundredActorDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List getAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Actores> theQuery = currentSession.createQuery("from Actores", Actores.class);
        return theQuery.getResultList();
    }

    @Override
    public Object getByID(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Actor.class, id);
    }

    @Override
    public void save(Object o) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(o);
    }

    @Override
    public void delete(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<?> theQuery = currentSession.createQuery("delete from Actores where id=:Id");
        theQuery.setParameter("Id", id);

        theQuery.executeUpdate();
    }
}
