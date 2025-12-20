package com.cafemenu.service;

import com.cafemenu.model.baseModel.MenuItem;
import com.cafemenu.model.dto.DTO;
import com.cafemenu.repository.Repository;
import com.cafemenu.factory.MenuItemFactory;

import java.util.List;
import java.util.NoSuchElementException;

public class ServiceImpl implements Service {
    private final Repository repo;
    private final MenuItemFactory factory;

    public ServiceImpl(Repository repo, MenuItemFactory factory) {
        this.repo = repo;
        this.factory = factory;
    }

    @Override
    public void createMenuItem(DTO dto) {
        System.out.println("Creating menu item: " + dto.getId());

        if (!validateMenuItem(dto)) {
            throw new IllegalArgumentException("Data menu tidak valid");
        }

        if (repo.existsById(dto.getId())) {
            throw new IllegalArgumentException("ID menu sudah ada: " + dto.getId());
        }

        MenuItem menuItem = factory.createMenuItem(dto);

        if (!menuItem.isValid()) {
            throw new IllegalArgumentException("Data menu tidak valid");
        }

        repo.save(menuItem);

        System.out.println("Menu item created successfully: " + dto.getId());
    }

    @Override
    public void updateMenuItem(DTO dto) {
        System.out.println("Updating menu item: " + dto.getId());

        if (!validateMenuItem(dto)) {
            throw new IllegalArgumentException("Data menu tidak valid");
        }

        MenuItem menuItem = factory.createMenuItem(dto);

        if (!menuItem.isValid()) {
            throw new IllegalArgumentException("Data menu tidak valid");
        }

        repo.update(menuItem);

        System.out.println("Menu item updated successfully: " + dto.getId());
    }

    @Override
    public void deleteMenuItem(String id) {
        System.out.println("Deleting menu item: " + id);

        if (!repo.existsById(id)) {
            throw new IllegalArgumentException("Data menu tidak ditemukan: " + id);
        }
        repo.delete(id);

        System.out.println("Menu item deleted successfully: " + id);
    }

    @Override
    public MenuItem getMenuItem(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Id menu tidak ditemukan: " + id));
    }

    @Override
    public List<MenuItem> getMenuByCategory(String category) {
        return repo.findByCategory(category);
    }

    @Override
    public List<MenuItem> getMenuByType(String type) {
        return repo.findByType(type);
    }

    @Override
    public List<MenuItem> getAllMenuItems() {
        List<MenuItem> items = repo.findAll();
        System.out.println("Retrieved " + items.size() + " menu items from repository");
        return items;
    }

    @Override
    public boolean validateMenuItem(DTO dto) {
        if (dto == null) {
            System.err.println("DTO is null");
            return false;
        }

        if (dto.getId() == null || dto.getId().trim().isEmpty()) {
            System.err.println("ID is empty");
            return false;
        }

        if (dto.getName() == null || dto.getName().trim().isEmpty()) {
            System.err.println("Name is empty");
            return false;
        }

        if (dto.getPrice() <= 0) {
            System.err.println("Price must be positive: " + dto.getPrice());
            return false;
        }

        if (dto.getCategory() == null || dto.getCategory().trim().isEmpty()) {
            System.err.println("Category is empty");
            return false;
        }

        String type = dto.getType();
        if (type == null) {
            System.err.println("Type is null");
            return false;
        }

        if (!type.equalsIgnoreCase("drink") && !type.equalsIgnoreCase("food")) {
            System.err.println("Invalid type: " + type);
            return false;
        }

        String id = dto.getId();
        if (type.equalsIgnoreCase("food") && !id.matches("F\\d{3}")) {
            System.err.println("Invalid Food ID format: " + id);
            return false;
        }
        if (type.equalsIgnoreCase("drink") && !id.matches("D\\d{3}")) {
            System.err.println("Invalid Drink ID format: " + id);
            return false;
        }

        return true;
    }

    @Override
    public List<String> getAllKategori() {
        List<String> categories = repo.getAllCategories();
        System.out.println("Retrieved " + categories.size() + " categories from repository");
        return categories;
    }
}