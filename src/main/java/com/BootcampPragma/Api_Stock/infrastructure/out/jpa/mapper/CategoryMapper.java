package com.BootcampPragma.Api_Stock.infrastructure.out.jpa.mapper;

import com.BootcampPragma.Api_Stock.domain.model.Category;
import com.BootcampPragma.Api_Stock.infrastructure.Utils.InfraConstants;
import com.BootcampPragma.Api_Stock.infrastructure.out.jpa.entity.CategoryEntity;
import  org.mapstruct.Mapper;


@Mapper(componentModel = InfraConstants.SPRING)
public interface CategoryMapper {

    Category toCategory(CategoryEntity category);
    CategoryEntity toCategoryEntity(Category category);
}
