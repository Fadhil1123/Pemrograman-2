package com.cafemenu.service;

import com.cafemenu.model.baseModel.MenuItem;
import com.cafemenu.model.dto.DTO;
import java.util.List;

public interface Service {
    void createMenuItem(DTO dto);
    void updateMenuItem(DTO dto);
    void deleteMenuItem(String id);

    MenuItem getMenuItem(String id);
    List<MenuItem> getMenuByCategory(String category);
    List<MenuItem> getMenuByType(String type);
    List<MenuItem> getAllMenuItems();

    boolean validateMenuItem(DTO dto);

    List<String> getAllKategori();
}