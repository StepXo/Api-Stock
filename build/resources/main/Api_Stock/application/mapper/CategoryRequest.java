package com.BootcampPragma.Api_Stock.application.mapper;

import com.BootcampPragma.Api_Stock.application.dto.CategoryDto;
import com.BootcampPragma.Api_Stock.domain.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface CategoryRequest {

    Category toCategory(CategoryDto category);
    CategoryDto toCategoryDto(Category categoryDto);

}
