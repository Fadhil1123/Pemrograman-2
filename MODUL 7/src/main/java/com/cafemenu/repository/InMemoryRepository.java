package com.cafemenu.repository;

import com.cafemenu.model.baseModel.MenuItem;
import java.util.*;
import java.util.stream.Collectors;

public class InMemoryRepository implements Repository {
    private Map<String, MenuItem> menuMap = new HashMap<>();

    @Override
    public void save(MenuItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Item tidak boleh kosong");
        }

        if (!item.isValid()) {
            throw new IllegalArgumentException("Item tidak valid");
        }

        menuMap.put(item.getId(), item);
        System.out.println("Saved item: " + item.getId() + " - " + item.getName());
    }

    @Override
    public void update(MenuItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Item tidak boleh kosong");
        }

        if (!item.isValid()) {
            throw new IllegalArgumentException("Item tidak valid");
        }

        if (!menuMap.containsKey(item.getId())) {
            throw new NoSuchElementException("Id item tidak ditemukan: " + item.getId());
        }
        menuMap.put(item.getId(), item);
        System.out.println("Updated item: " + item.getId() + " - " + item.getName());
    }

    @Override
    public void delete(String id) {
        if (id == null || !menuMap.containsKey(id)) {
            throw new NoSuchElementException("Item tidak ditemukan: " + id);
        }
        menuMap.remove(id);
        System.out.println("Deleted item: " + id);
    }

    @Override
    public Optional<MenuItem> findById(String id) {
        return Optional.ofNullable(menuMap.get(id));
    }

    @Override
    public List<MenuItem> findAll() {
        List<MenuItem> items = new ArrayList<>(menuMap.values());
        System.out.println("Returning " + items.size() + " items from repository");
        return items;
    }

    @Override
    public List<MenuItem> findByType(String type) {
        return menuMap.values().stream()
                .filter(item -> item.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }

    @Override
    public List<MenuItem> findByCategory(String category) {
        return menuMap.values().stream()
                .filter(item -> item.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    @Override
    public boolean existsById(String id) {
        return menuMap.containsKey(id);
    }

    @Override
    public List<String> getAllCategories() {
        List<String> categories = menuMap.values().stream()
                .map(MenuItem::getCategory)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Returning " + categories.size() + " categories");
        return categories;
    }
}