package dev.chrono.chronochallenge.service;

import java.util.List;

public interface CrudService<T, ID> {
    List<T> findAll();
    T findById(ID id);
    T save(T t);
    void delete(T t);
    void deleteById(ID id);
}
