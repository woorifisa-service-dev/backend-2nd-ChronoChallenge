package dev.chrono.chronochallenge.common.service;

import java.util.List;

public interface CrudService<T, ID> {
    List<T> findAll();
    T findById(ID id);
    T save(T t);
    void deleteById(ID id);
}