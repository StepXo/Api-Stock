package com.BootcampPragma.Api_Emazon.domain.model;

public class Item {
    private long id;
    private String name;
    private String description;
    private Long quantity;
    private double price;
    private Long id_category;
    private Long id_brand;

    public Item(long id, String name, String description, Long quantity, double price, Long id_category, Long id_brand) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.id_category = id_category;
        this.id_brand = id_brand;
    }

    public Long getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public Long getId_category() {return id_category;}

    public Long getId_brand() {return id_brand;}

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId_category(Long id_category) {this.id_category = id_category;}

    public void setId_brand(Long id_brand) {this.id_brand = id_brand;}
}
