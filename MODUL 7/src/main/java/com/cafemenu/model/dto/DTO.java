package com.cafemenu.model.dto;

public class DTO {
    private String id;
    private String name;
    private double price;
    private String category;
    private String type;
    private String description;

    public DTO(){}

    public DTO id(String id) {this.id = id; return this; };
    public DTO name(String name) {this.name = name; return this; };
    public DTO price(double price) {this.price = price; return this; };
    public DTO category(String category) {this.category = category; return this; };
    public DTO type (String type){this.type = type; return this;};
    public DTO description(String description) {this.description = description; return this; };

    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
    public String getType(){return type;}
    public String getDescription() { return description; }
}