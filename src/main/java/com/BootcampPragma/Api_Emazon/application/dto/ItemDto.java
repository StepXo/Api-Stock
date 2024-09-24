package com.BootcampPragma.Api_Emazon.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {
    private long id;
    private String name;
    private String description;
    private long quantity;
    private double price;
    private List<Long> categoryId;
    private Long brandId;

}
