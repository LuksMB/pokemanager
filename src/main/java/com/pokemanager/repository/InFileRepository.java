package com.pokemanager.repository;
import java.io.*;
import java.util.*;

public class InFileRepository<T> implements CrudRepository<T> {
    private final String fileName;

    public InFileRepository(String fileName) {
        this.fileName = fileName;
        useFile();
    }

    private void useFile() {
        File file = new File(fileName);
        try {
            if (!file.exists()) {
                file.createNewFile();
                saveToFile(new HashMap<Integer, T>());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private Map<Integer, T> loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Map<Integer, T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new HashMap<>();
        }
    }

    private void saveToFile(Map<Integer, T> data) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(T entity) {
        Map<Integer, T> data = loadFromFile();
        int id = data.size() + 1;
        data.put(id, entity);
        saveToFile(data);
    }

    @Override
    public T findById(int id) {
        return loadFromFile().get(id);
    }

    @Override
    public void update(T entity) {
        Map<Integer, T> data = loadFromFile();
        for (Map.Entry<Integer, T> entry : data.entrySet()) {
            if (entry.getValue().equals(entity)) {
                data.put(entry.getKey(), entity);
                saveToFile(data);
                return;
            }
        }
    }

    @Override
    public void delete(int id) {
        Map<Integer, T> data = loadFromFile();
        data.remove(id);
        saveToFile(data);
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(loadFromFile().values());
    }
}
