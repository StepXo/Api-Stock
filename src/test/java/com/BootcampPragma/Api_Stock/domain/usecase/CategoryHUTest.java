package com.BootcampPragma.Api_Stock.domain.usecase;

import com.BootcampPragma.Api_Stock.domain.exeption.DescriptionIsTooLongException;
import com.BootcampPragma.Api_Stock.domain.exeption.NameIsTooLongException;
import com.BootcampPragma.Api_Stock.domain.model.Category;
import com.BootcampPragma.Api_Stock.domain.spi.CategoryPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CategoryHUTest {

    @Mock
    private CategoryPersistencePort categoryPersistencePort;

    @InjectMocks
    private CategoryHU categoryHU;

    private Category category;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        category = new Category(1L, "Test Category", "Description");
    }

    @Test
    void saveCategory_Success() {
        when(categoryPersistencePort.saveCategory(category)).thenReturn(category);

        Category savedCategory = categoryHU.saveCategory(category);

        assertNotNull(savedCategory);
        assertEquals(category.getName(), savedCategory.getName());
        verify(categoryPersistencePort, times(1)).saveCategory(category);
    }

    @Test
    void saveCategory_NameTooLong() {
        Category longNameCategory = new Category(1L, "A".repeat(51), "Description");

        NameIsTooLongException thrown = assertThrows(NameIsTooLongException.class, () -> {
            categoryHU.saveCategory(longNameCategory);
        });

        assertNotNull(thrown);
        verify(categoryPersistencePort, never()).saveCategory(any());
    }

    @Test
    void saveCategory_DescriptionTooLong() {
        Category longDescriptionCategory = new Category(1L, "Category", "A".repeat(121));

        DescriptionIsTooLongException thrown = assertThrows(DescriptionIsTooLongException.class, () -> {
            categoryHU.saveCategory(longDescriptionCategory);
        });

        assertNotNull(thrown);
        verify(categoryPersistencePort, never()).saveCategory(any());
    }

    @Test
    void getAllCategorys() {
        when(categoryPersistencePort.getAllCategories()).thenReturn(List.of(category));

        List<Category> categorys = categoryHU.getAllCategories();

        assertNotNull(categorys);
        assertEquals(1, categorys.size());
        assertEquals(category.getName(), categorys.get(0).getName());
        verify(categoryPersistencePort, times(1)).getAllCategories();
    }

    @Test
    void updateCategory_Success() {
        when(categoryPersistencePort.saveCategory(category)).thenReturn(category);

        assertDoesNotThrow(() -> categoryHU.updateCategory(category));

        verify(categoryPersistencePort, times(1)).saveCategory(category);
    }

    @Test
    void updateCategory_NameTooLong() {
        Category longNameCategory = new Category(1L, "A".repeat(51), "Description");

        NameIsTooLongException thrown = assertThrows(NameIsTooLongException.class, () -> {
            categoryHU.updateCategory(longNameCategory);
        });

        assertNotNull(thrown);
        verify(categoryPersistencePort, never()).saveCategory(any());
    }

    @Test
    void updateCategory_DescriptionTooLong() {
        Category longDescriptionCategory = new Category(1L, "Category", "A".repeat(121));

        DescriptionIsTooLongException thrown = assertThrows(DescriptionIsTooLongException.class, () -> {
            categoryHU.updateCategory(longDescriptionCategory);
        });

        assertNotNull(thrown);
        verify(categoryPersistencePort, never()).saveCategory(any());
    }

    @Test
    void getCategory_Success() {
        when(categoryPersistencePort.getCategory(category.getName())).thenReturn(category);

        Category foundCategory = categoryHU.getCategory(category.getName());

        assertNotNull(foundCategory);
        assertEquals(category.getName(), foundCategory.getName());
        verify(categoryPersistencePort, times(1)).getCategory(category.getName());
    }

}
