package com.cafemenu.model.baseModel;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class MenuItem {
    protected final StringProperty id;
    protected final StringProperty name;
    protected final StringProperty description;
    protected final DoubleProperty price;
    protected final StringProperty category;

    public MenuItem() {
        this.id = new SimpleStringProperty();
        this.name = new SimpleStringProperty();
        this.description = new SimpleStringProperty();
        this.price = new SimpleDoubleProperty();
        this.category = new SimpleStringProperty();
    }

    public MenuItem(String id, String name, String description, double price, String category) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.description = new SimpleStringProperty(description);
        this.price = new SimpleDoubleProperty(price);
        this.category = new SimpleStringProperty(category);
    }

    public abstract String getType();

    public String getId() { return id.get(); }
    public void setId(String id) { this.id.set(id); }
    public StringProperty idProperty() { return id; }

    public String getName() { return name.get(); }
    public void setName(String name) { this.name.set(name); }
    public StringProperty nameProperty() { return name; }

    public String getDescription() { return description.get(); }
    public void setDescription(String description) { this.description.set(description); }
    public StringProperty descriptionProperty() { return description; }

    public double getPrice() { return price.get(); }
    public void setPrice(double price) { this.price.set(price); }
    public DoubleProperty priceProperty() { return price; }

    public String getCategory() { return category.get(); }
    public void setCategory(String category) { this.category.set(category); }
    public StringProperty categoryProperty() { return category; }

    public final boolean isValid() {
        return validateId() && validateName() && validatePrice();
    }

    public abstract boolean validateId();
    public abstract boolean validateName();
    public boolean validatePrice() { return getPrice() >= 0; }

    @Override
    public String toString() {
        return String.format("%s - %s (Rp%,.0f)", getId(), getName(), getPrice());
    }
}