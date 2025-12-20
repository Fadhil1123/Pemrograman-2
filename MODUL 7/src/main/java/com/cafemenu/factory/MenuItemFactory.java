package com.cafemenu.factory;

import com.cafemenu.model.baseModel.MenuItem;
import com.cafemenu.model.concreteModel.Drink;
import com.cafemenu.model.concreteModel.Food;
import com.cafemenu.model.dto.DTO;

public class MenuItemFactory {

    public MenuItem createMenuItem(DTO dto) {
        if (dto == null) {
            throw new IllegalArgumentException("DTO tidak boleh kosong");
        }

        String type = dto.getType();
        if (type == null) {
            throw new IllegalArgumentException("Type tidak boleh kosong");
        }

        switch (type.toLowerCase()) {
            case "drink":
                return createDrink(dto);
            case "food":
                return createFood(dto);
            default:
                throw new IllegalArgumentException("Type tidak valid: " + type + ". Harus 'drink' atau 'food'");
        }
    }

    private Drink createDrink(DTO dto) {
        Drink drink = new Drink();
        drink.setId(dto.getId());
        drink.setName(dto.getName());
        drink.setDescription(dto.getDescription());
        drink.setCategory(dto.getCategory());
        drink.setPrice(dto.getPrice());
        return drink;
    }

    private Food createFood(DTO dto) {
        Food food = new Food();
        food.setId(dto.getId());
        food.setName(dto.getName());
        food.setDescription(dto.getDescription());
        food.setCategory(dto.getCategory());
        food.setPrice(dto.getPrice());
        return food;
    }
}