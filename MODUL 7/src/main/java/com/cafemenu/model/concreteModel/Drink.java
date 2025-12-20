package com.cafemenu.model.concreteModel;

import com.cafemenu.model.baseModel.MenuItem;

public class Drink extends MenuItem {
    public Drink() {
        super();
    }


    @Override
    public String getType() {
        return "Drink";
    }

    @Override
    public boolean validateId() {
        return getId() != null && getId().matches("D\\d{3}");
    }

    @Override
    public boolean validateName() {
        return getName() != null && getName().length() >= 3;
    }

    @Override
    public String toString() {
        return String.format("%s [Drink] - %s (Rp%,.0f)",
                getId(), getName(), getPrice());
    }
}