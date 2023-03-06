package com.oneHundre.oneHundre.DAO;

import com.oneHundre.oneHundre.entity.Actor;
import com.oneHundre.oneHundre.entity.Actores;

import java.util.List;

public interface HundredGenericsDAO<T> {
    List<T> getAll();
    T getByID(int id);
    void save(T t);
    void delete(int id);
}
