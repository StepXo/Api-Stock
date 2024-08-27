package com.BootcampPragma.Api_Emazon.application.service;

import com.BootcampPragma.Api_Emazon.application.dto.CategoryDto;
import com.BootcampPragma.Api_Emazon.application.mapper.CategoryRequest;
import com.BootcampPragma.Api_Emazon.domain.api.CategoryServicePort;
import com.BootcampPragma.Api_Emazon.domain.model.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

//@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

    @Mock
    private CategoryServicePort categoryServicePort;

    @Mock
    private CategoryRequest categoryRequest;

    @InjectMocks
    private CategoryService categoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveCategory_Positive() {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName("Electronics");
        categoryDto.setDescription("Devices and gadgets");

        Category category = new Category(1L, "Electronics", "Devices and gadgets");

        when(categoryRequest.toCategory(categoryDto)).thenReturn(category);

        categoryService.saveCategory(categoryDto);

        verify(categoryRequest, times(1)).toCategory(categoryDto); // Verifica que se llame a toCategory
        verify(categoryServicePort, times(1)).saveCategory(category); // Verifica que se llame a saveCategory
    }

    @Test
    void testGetCategoriesOrderedByName_Positive() {

        Category category1 = new Category(1, "Books", "Books Category");

        Category category2 = new Category(2, "Electronics", "Electronics Category");

        CategoryDto categoryDto1 =new CategoryDto();
        categoryDto1.setName("Books");
        categoryDto1.setDescription("Books Category");

        CategoryDto categoryDto2 =new CategoryDto();
        categoryDto2.setName("Electronics");
        categoryDto2.setDescription("Devices and gadgets");


        when(categoryServicePort.getAllCategories()).thenReturn(List.of(category1, category2));
        when(categoryRequest.toCategoryDto(category1)).thenReturn(categoryDto1);
        when(categoryRequest.toCategoryDto(category2)).thenReturn(categoryDto2);

        Page<CategoryDto> result = categoryService.getCategoriesOrderedByName("asc", 0, 10);

        assertNotNull(result);
        assertEquals(2, result.getContent().size(), "The number of categories in the result should be 2");
        assertEquals("Books", result.getContent().get(0).getName(), "The first category should be 'Books'");
        assertEquals("Electronics", result.getContent().get(1).getName(), "The second category should be 'Electronics'");
    }

    @Test
    void testGetCategoriesOrderedByName_Negative() {
        int page = 0, size = 10;
        Pageable pageable = PageRequest.of(page, size);

        when(categoryServicePort.getAllCategories()).thenReturn(List.of());

        Page<CategoryDto> result = categoryService.getCategoriesOrderedByName("asc", page, size);

        assertNotNull(result);
        assertTrue(result.getContent().isEmpty());
    }
}

