package com.cafemenu.model.concreteModel;

import com.cafemenu.model.baseModel.MenuItem;

public class Food extends MenuItem {
    public Food() {
        super();
    }

    @Override
    public String getType() {
        return "Food";
    }

    @Override
    public boolean validateId() {
        return getId() != null && getId().matches("F\\d{3}");
    }

    @Override
    public boolean validateName() {
        return getName() != null && getName().length() >= 3;
    }

    @Override
    public String toString() {
        return String.format("%s [Food] - %s (Rp%,.0f)",
                getId(), getName(), getPrice());
    }
}
