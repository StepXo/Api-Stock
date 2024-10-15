package com.BootcampPragma.Api_Stock.infrastructure.out.jpa.entity;

import com.BootcampPragma.Api_Stock.infrastructure.Utils.InfraConstants;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = InfraConstants.CATEGORY_TABLE)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    @Column(unique = true)
    private String name;

    private String description;


}
