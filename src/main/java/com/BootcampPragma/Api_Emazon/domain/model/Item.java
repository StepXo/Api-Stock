package com.BootcampPragma.Api_Emazon.domain.model;

import java.util.List;

public class Item {
    private long id;
    private String name;
    private String description;
    private long quantity;
    private double price;
    private List<Long> category_id;
    private long brand_id;

    public Item(long id, String name, String description, long quantity, double price, List<Long> category_id, long brand_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.category_id = category_id;
        this.brand_id = brand_id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public long getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public List<Long> getCategory_id() {
        return category_id;
    }

    public long getBrand_id() {
        return brand_id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory_id(List<Long> category_id) {
        this.category_id = category_id;
    }

    public void setBrand_id(long brand_id) {
        this.brand_id = brand_id;
    }
}
