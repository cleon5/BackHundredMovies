package com.oneHundre.oneHundre.DAO;

import com.oneHundre.oneHundre.entity.Actor;
import com.oneHundre.oneHundre.entity.Actores;
import com.oneHundre.oneHundre.entity.Movie;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class HundredActorDAOImpl implements HundredActorDAO {
    private EntityManager entityManager;
    @Autowired
    public HundredActorDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Actores> allActor() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Actores> theQuery = currentSession.createQuery("from Actores", Actores.class);
        List<Actores> actores = theQuery.getResultList();

        return actores;
    }

    @Override
    public void saveActor(Actor actor) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(actor);
    }

    @Override
    public void deleteActor(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<?> theQuery = currentSession.createQuery("delete from Actores where id=:Id");
        theQuery.setParameter("Id", id);

        theQuery.executeUpdate();
    }

    @Override
    public Actor actorId(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Actor actor = currentSession.get(Actor.class, id);
        return actor;
    }
}
