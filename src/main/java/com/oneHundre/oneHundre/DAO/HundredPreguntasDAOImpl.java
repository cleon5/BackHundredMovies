package com.oneHundre.oneHundre.DAO;

import com.oneHundre.oneHundre.entity.Genero;
import com.oneHundre.oneHundre.entity.Pregunta;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class HundredPreguntasDAOImpl implements HundredGenericsDAO {
    private final EntityManager entityManager;
    @Autowired
    public HundredPreguntasDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    public List getAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<?> theQuery = currentSession.createQuery("from Pregunta", Pregunta.class);
        return theQuery.getResultList();
    }

    @Override
    public Object getByID(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Pregunta.class, id);
    }

    @Override
    public void save(Object o) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(o);
    }

    @Override
    public void delete(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<?> theQuery = currentSession.createQuery("delete from Pregunta where id=:Id");
        theQuery.setParameter("Id", id);

        theQuery.executeUpdate();
    }
}
