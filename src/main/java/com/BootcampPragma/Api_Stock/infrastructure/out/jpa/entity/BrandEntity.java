package com.BootcampPragma.Api_Stock.infrastructure.out.jpa.entity;

import com.BootcampPragma.Api_Stock.infrastructure.Utils.InfraConstants;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = InfraConstants.BRAND_TABLE)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BrandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String name;

    private String description;


}
