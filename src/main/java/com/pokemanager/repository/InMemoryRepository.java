package com.pokemanager.repository;
import java.util.*;
public class InMemoryRepository<T> implements CrudRepository<T> {
    private final Map<Integer, T> storage = new HashMap<>();
    private int currentId = 1; // Simula ID auto-incremento

    @Override
    public void save(T entity) {
        storage.put(currentId++, entity);
    }

    @Override
    public T findById(int id) {
        return storage.get(id);
    }

    @Override
    public void update(T entity) {
        for (Map.Entry<Integer, T> entry : storage.entrySet()) {
            if (entry.getValue().equals(entity)) {
                storage.put(entry.getKey(), entity);
                return;
            }
        }
    }

    @Override
    public void delete(int id) {
        storage.remove(id);
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(storage.values());
    }
}