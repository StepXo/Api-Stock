package com.BootcampPragma.Api_Stock.infrastructure.out.jpa.mapper;

import com.BootcampPragma.Api_Stock.domain.model.Category;
import com.BootcampPragma.Api_Stock.infrastructure.out.jpa.entity.CategoryEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category toCategory(CategoryEntity category);
    CategoryEntity toCategoryEntity(Category category);
}
