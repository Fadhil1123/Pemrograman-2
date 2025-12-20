package com.cafemenu.repository;

import com.cafemenu.model.baseModel.MenuItem;
import java.util.List;
import java.util.Optional;

public interface Repository {
    void save(MenuItem item);
    void update(MenuItem item);
    void delete(String id);

    Optional<MenuItem> findById(String id);
    List<MenuItem> findAll();
    List<MenuItem> findByType(String type);
    List<MenuItem> findByCategory(String category);

    boolean existsById(String id);
    List<String> getAllCategories();
}