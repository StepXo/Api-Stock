package com.BootcampPragma.Api_Emazon.domain.usecase;

import com.BootcampPragma.Api_Emazon.domain.api.CategoryServicePort;
import com.BootcampPragma.Api_Emazon.domain.exeption.DescriptionIsTooLongException;
import com.BootcampPragma.Api_Emazon.domain.exeption.NameIsTooLongException;
import com.BootcampPragma.Api_Emazon.domain.model.Category;
import com.BootcampPragma.Api_Emazon.domain.spi.CategoryPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CategoryHUTest {

    @Mock
    private CategoryPersistencePort categoryPersistencePort;

    @InjectMocks
    private CategoryHU categoryHU;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveCategory_Positive() {
        Category category = new Category(1, "Books", "Books Category");

        when(categoryPersistencePort.saveCategory(category)).thenReturn(category);

        Category result = categoryHU.saveCategory(category);

        assertNotNull(result);
        assertEquals("Books", result.getName());
        verify(categoryPersistencePort, times(1)).saveCategory(category);
    }

    @Test
    void testSaveCategory_NameTooLong_Negative() {
        Category category = new Category(1, "This is a very long category name that exceeds fifty characters", "Books Category");

        assertThrows(NameIsTooLongException.class, () -> categoryHU.saveCategory(category));
        verify(categoryPersistencePort, never()).saveCategory(any());
    }

    @Test
    void testSaveCategory_DescriptionTooLong_Negative() {
        Category category = new Category(1, "Books", "This is a very long description that exceeds ninety characters, and it should throw an exception");

        assertThrows(DescriptionIsTooLongException.class, () -> categoryHU.saveCategory(category));
        verify(categoryPersistencePort, never()).saveCategory(any());
    }
}
