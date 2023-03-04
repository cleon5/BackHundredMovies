package com.oneHundre.oneHundre.DAO;

import com.oneHundre.oneHundre.entity.Actores;
import com.oneHundre.oneHundre.entity.Saga;

import java.util.List;

public interface HundredSagaDAO {
    List<Saga> allSaga();
    Saga sagaId(int id);
    void saveSaga(Saga saga);
    void deleteSaga(int id);
}
