package com.BootcampPragma.Api_Stock.infrastructure.out.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    private String name;
    private String description;
    private long quantity;
    private double price;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "article_category",
            joinColumns = @JoinColumn(name = "item_id"),
    inverseJoinColumns = @JoinColumn(name = "category_id"))
    List<CategoryEntity> category;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brand")
    private BrandEntity brand;

}
