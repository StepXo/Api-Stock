package com.BootcampPragma.Api_Emazon.application.service;

import com.BootcampPragma.Api_Emazon.application.dto.CategoryDto;
import com.BootcampPragma.Api_Emazon.application.mapper.CategoryRequest;


import com.BootcampPragma.Api_Emazon.domain.api.CategoryServicePort;
import com.BootcampPragma.Api_Emazon.domain.model.Category;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryService {

    private final CategoryRequest categoryRequest;
    private  final CategoryServicePort categoryServicePort;

    public List<CategoryDto> getAllCategories() {
        return categoryServicePort
                .getAllCategories()
                .stream()
                .map(categoryRequest::toCategoryDto)
                .collect(Collectors.toList()
                );
    }

    public void saveCategory(CategoryDto categoryDto){
        Category category = categoryRequest.toCategory(categoryDto);
        categoryServicePort.saveCategory(category);
    }

}
