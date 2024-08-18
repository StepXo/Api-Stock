package com.BootcampPragma.Api_Emazon.application.mapper;

import com.BootcampPragma.Api_Emazon.application.dto.CategoryDto;
import com.BootcampPragma.Api_Emazon.domain.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface CategoryRequest {

    Category toCategory(CategoryDto category);
    CategoryDto toCategoryDto(Category categoryDto);

}
