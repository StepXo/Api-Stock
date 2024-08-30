package com.BootcampPragma.Api_Emazon.application.service;

import com.BootcampPragma.Api_Emazon.application.dto.CategoryDto;
import com.BootcampPragma.Api_Emazon.application.mapper.CategoryRequest;
import com.BootcampPragma.Api_Emazon.domain.api.CategoryServicePort;
import com.BootcampPragma.Api_Emazon.domain.model.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CategoryServiceTest {

    @Mock
    private CategoryServicePort categoryServicePort;

    @Mock
    private CategoryRequest categoryRequest;

    @InjectMocks
    private CategoryService categoryService;

    private CategoryDto categoryDto;
    private CategoryDto categoryDto2;

    private Category category;
    private Category category2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        category = new Category(1, "Books", "Books Category");
        categoryDto = new CategoryDto(1, "Books", "Books Category");
        category2 = new Category(2, "Electronics", "Electronics Category");
        categoryDto2 = new CategoryDto(2, "Electronics", "Electronics Category");

    }

    @Test
    void testSaveCategory_Positive() {

        when(categoryRequest.toCategory(categoryDto)).thenReturn(category);
        assertDoesNotThrow(() -> categoryService.saveCategory(categoryDto));

        verify(categoryRequest, times(1)).toCategory(categoryDto); // Verifica que se llame a toCategory
        verify(categoryServicePort, times(1)).saveCategory(category); // Verifica que se llame a saveCategory
    }



    @Test
    void testGetCategoriesOrderedByName_Positive() {

        when(categoryServicePort.getAllCategories()).thenReturn(List.of(category, category2));
        when(categoryRequest.toCategoryDto(category)).thenReturn(categoryDto);
        when(categoryRequest.toCategoryDto(category2)).thenReturn(categoryDto2);

        Page<CategoryDto> result = categoryService.getCategoriesOrderedByName("asc", 0, 10);

        assertNotNull(result);
        assertEquals(2, result.getContent().size(), "The number of categories in the result should be 2");
        assertEquals("Books", result.getContent().get(0).getName(), "The first category should be 'Books'");
        assertEquals("Electronics", result.getContent().get(1).getName(), "The second category should be 'Electronics'");
    }

    @Test
    void testGetCategoriesOrderedByName_Negative() {


        when(categoryServicePort.getAllCategories()).thenReturn(List.of());

        Page<CategoryDto> result = categoryService.getCategoriesOrderedByName("asc", 0, 10);

        assertNotNull(result);
        assertTrue(result.getContent().isEmpty());
    }
}
