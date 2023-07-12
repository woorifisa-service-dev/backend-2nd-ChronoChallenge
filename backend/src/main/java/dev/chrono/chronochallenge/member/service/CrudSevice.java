package dev.chrono.chronochallenge.member.service;

import java.util.List;

public interface CrudSevice<T, ID> {
    List<T> findAll();
    T findById(ID id);
    T save(T t);
    void delete(T t);
    void deleteById(ID id);
}