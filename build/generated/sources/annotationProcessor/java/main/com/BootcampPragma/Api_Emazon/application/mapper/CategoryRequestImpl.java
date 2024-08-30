package com.BootcampPragma.Api_Emazon.application.mapper;

import com.BootcampPragma.Api_Emazon.application.dto.CategoryDto;
import com.BootcampPragma.Api_Emazon.domain.model.Category;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-29T21:41:23-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.12 (Amazon.com Inc.)"
)
@Component
public class CategoryRequestImpl implements CategoryRequest {

    @Override
    public Category toCategory(CategoryDto category) {
        if ( category == null ) {
            return null;
        }

        Category category1 = new Category();

        category1.setId( category.getId() );
        category1.setName( category.getName() );
        category1.setDescription( category.getDescription() );

        return category1;
    }

    @Override
    public CategoryDto toCategoryDto(Category categoryDto) {
        if ( categoryDto == null ) {
            return null;
        }

        CategoryDto categoryDto1 = new CategoryDto();

        categoryDto1.setId( categoryDto.getId() );
        categoryDto1.setName( categoryDto.getName() );
        categoryDto1.setDescription( categoryDto.getDescription() );

        return categoryDto1;
    }
}
