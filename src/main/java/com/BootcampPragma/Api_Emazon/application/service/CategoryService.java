package com.BootcampPragma.Api_Emazon.application.service;

import com.BootcampPragma.Api_Emazon.application.dto.CategoryDto;
import com.BootcampPragma.Api_Emazon.application.mapper.CategoryRequest;
import com.BootcampPragma.Api_Emazon.domain.api.CategoryServicePort;
import com.BootcampPragma.Api_Emazon.domain.model.Category;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryService {

    private final CategoryRequest categoryRequest;
    private  final CategoryServicePort categoryServicePort;

    public void saveCategory(CategoryDto categoryDto){
        Category category = categoryRequest.toCategory(categoryDto);
        categoryServicePort.saveCategory(category);
    }
    public List<Category> getAllCategories(List<String> names) {
        return names.stream()
                .map(categoryServicePort::getCategory)
                .collect(Collectors.toList());
    }


    public Page<CategoryDto> getCategoriesOrderedByName(String order, int page, int size) {
        Sort sort = "asc".equalsIgnoreCase(order)
                ? Sort.by("name").descending()
                : Sort.by("name").ascending();
        Pageable pageable = PageRequest.of(page, size, sort);

        List<CategoryDto> categoryDto = categoryServicePort
                .getAllCategories()
                .stream()
                .map(categoryRequest::toCategoryDto)
                .toList();

        Comparator<CategoryDto> comparator = "asc".equalsIgnoreCase(order)
                ? Comparator.comparing(CategoryDto::getName)
                : Comparator.comparing(CategoryDto::getName).reversed();

        List<CategoryDto> sortedCategoryDto = categoryDto.stream()
                .sorted(comparator)
                .toList();

        int start = (int) pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize(), sortedCategoryDto.size());

        return new PageImpl<>(sortedCategoryDto.subList(start, end), pageable, sortedCategoryDto.size());
    }

    public CategoryDto getCategory(String name){
        Category category = categoryServicePort.getCategory(name);
        return categoryRequest.toCategoryDto(category);
    }


}
