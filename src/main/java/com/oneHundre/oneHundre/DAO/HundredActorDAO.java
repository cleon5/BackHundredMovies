package com.oneHundre.oneHundre.DAO;

import com.oneHundre.oneHundre.entity.Actor;
import com.oneHundre.oneHundre.entity.Actores;
import com.oneHundre.oneHundre.entity.Movie;

import java.util.List;

public interface HundredActorDAO {
    List<Actores> allActor();
    Actor actorId(int id);
    void saveActor(Actor actor);
    void deleteActor(int id);
}
