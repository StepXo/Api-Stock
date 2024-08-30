package com.BootcampPragma.Api_Emazon.application.service;

import com.BootcampPragma.Api_Emazon.application.dto.CategoryDto;
import com.BootcampPragma.Api_Emazon.application.mapper.CategoryRequest;
import com.BootcampPragma.Api_Emazon.application.util.PaginationUtil;
import com.BootcampPragma.Api_Emazon.application.util.SorterUtil;
import com.BootcampPragma.Api_Emazon.domain.api.CategoryServicePort;
import com.BootcampPragma.Api_Emazon.domain.model.Category;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryService {

    private final CategoryRequest categoryRequest;
    private  final CategoryServicePort categoryServicePort;
    private final SorterUtil sorterUtil;
    private final PaginationUtil paginationUtil;

    public void saveCategory(CategoryDto categoryDto){
        Category category = categoryRequest.toCategory(categoryDto);
        categoryServicePort.saveCategory(category);
    }

    public List<Category> getAllCategories(List<String> names) {
        return names.stream()
                .map(categoryServicePort::getCategory)
               .toList();
    }

    public Page<CategoryDto> getCategoriesOrderedByName(String order, int page, int size) {

        List<CategoryDto> categoryDto = categoryServicePort
                .getAllCategories()
                .stream()
                .map(categoryRequest::toCategoryDto)
                .toList();

        List<CategoryDto> sortedCategoryDto = sorterUtil.getSortedCategories(order,categoryDto);
        return paginationUtil.getCategoriesPagination(order, page, size, sortedCategoryDto);
    }

    public CategoryDto getCategory(String name){
        Category category = categoryServicePort.getCategory(name);
        return categoryRequest.toCategoryDto(category);
    }
}
