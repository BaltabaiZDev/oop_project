package kz.university.repository;

import java.util.List;

public interface Repository<T> {
    void save(T object);
    void delete(String id);
    T findById(String id);
    List<T> findAll();
}
