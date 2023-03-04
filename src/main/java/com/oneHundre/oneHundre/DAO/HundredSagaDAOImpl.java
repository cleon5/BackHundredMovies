package com.oneHundre.oneHundre.DAO;

import com.oneHundre.oneHundre.entity.Actor;
import com.oneHundre.oneHundre.entity.Actores;
import com.oneHundre.oneHundre.entity.Movie;
import com.oneHundre.oneHundre.entity.Saga;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
public class HundredSagaDAOImpl implements HundredSagaDAO {
    private EntityManager entityManager;
    @Autowired
    public HundredSagaDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }
    public List<Saga> allSaga() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Saga> theQuery = currentSession.createQuery("from Saga", Saga.class);
        List<Saga> sagas = theQuery.getResultList();

        return sagas;
    }

    @Override
    public Saga sagaId(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Saga saga = currentSession.get(Saga.class, id);
        return saga;
    }

    @Override
    public void saveSaga(Saga saga) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(saga);
    }

    @Override
    public void deleteSaga(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<?> theQuery = currentSession.createQuery("delete from Saga where id=:Id");
        theQuery.setParameter("Id", id);

        theQuery.executeUpdate();
    }


    // @Overrid

}
