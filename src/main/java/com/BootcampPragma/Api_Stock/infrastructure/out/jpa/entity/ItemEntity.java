package com.BootcampPragma.Api_Stock.infrastructure.out.jpa.entity;

import com.BootcampPragma.Api_Stock.infrastructure.Utils.InfraConstants;
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

    @Column(unique = true)
    private String name;

    private String description;

    private long quantity;

    private double price;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = InfraConstants.ARTICLE_CATEGORY,
            joinColumns = @JoinColumn(name = InfraConstants.ITEM_ID),
    inverseJoinColumns = @JoinColumn(name = InfraConstants.CATEGORY_ID))
    List<CategoryEntity> category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = InfraConstants.BRAND_NAME)
    private BrandEntity brand;

}
