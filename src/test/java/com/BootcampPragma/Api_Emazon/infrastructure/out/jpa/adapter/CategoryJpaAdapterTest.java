package com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.adapter;

import com.BootcampPragma.Api_Emazon.domain.model.Category;
import com.BootcampPragma.Api_Emazon.infrastructure.exeption.CategoryAlreadyExistsException;
import com.BootcampPragma.Api_Emazon.infrastructure.exeption.CategoryNotFoundException;
import com.BootcampPragma.Api_Emazon.infrastructure.exeption.DescriptionNotFoundException;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.entity.CategoryEntity;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.mapper.CategoryMapper;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategoryJpaAdapterTest {


    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private CategoryMapper categoryMapper;

    @InjectMocks
    private CategoryJpaAdapter categoryJpaAdapter;

    private Category category;
    private CategoryEntity categoryEntity;
    private String categoryName;
    private Long categoryId;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        categoryName = "Test Category";
        categoryId = 1L;
        category = new Category(categoryId, categoryName, "Description");
        categoryEntity = new CategoryEntity(categoryId, categoryName, "Description");
    }
    @Test
    void getAllCategorys() {
        when(categoryRepository.findAll()).thenReturn(List.of(categoryEntity));
        when(categoryMapper.toCategory(categoryEntity)).thenReturn(category);

        List<Category> categorys = categoryJpaAdapter.getAllCategories();

        assertNotNull(categorys);
        assertEquals(1, categorys.size());
        assertEquals(categoryName, categorys.get(0).getName());
        verify(categoryRepository, times(1)).findAll();
        verify(categoryMapper, times(1)).toCategory(categoryEntity);
    }

    @Test
    void saveCategory() {
        when(categoryRepository.findByName(categoryName)).thenReturn(Optional.empty());
        when(categoryMapper.toCategoryEntity(category)).thenReturn(categoryEntity);
        when(categoryRepository.save(categoryEntity)).thenReturn(categoryEntity);
        when(categoryMapper.toCategory(categoryEntity)).thenReturn(category);

        Category savedCategory = categoryJpaAdapter.saveCategory(category);

        assertNotNull(savedCategory);
        assertEquals(categoryName, savedCategory.getName());
        verify(categoryRepository, times(1)).findByName(categoryName);
        verify(categoryRepository, times(1)).save(categoryEntity);
        verify(categoryMapper, times(1)).toCategoryEntity(category);
        verify(categoryMapper, times(1)).toCategory(categoryEntity);
    }

    @Test
    void saveCategory_AlreadyExists() {
        when(categoryRepository.findByName(categoryName)).thenReturn(Optional.of(categoryEntity));

        CategoryAlreadyExistsException thrown = assertThrows(CategoryAlreadyExistsException.class, () -> {
            categoryJpaAdapter.saveCategory(category);
        });

        assertNotNull(thrown);
        verify(categoryRepository, times(1)).findByName(categoryName);
    }
    @Test
    void saveCategory_DescriptionNotFound() {
        Category categoryWithEmptyDescription = new Category(categoryId, categoryName, "");

        when(categoryRepository.findByName(categoryName)).thenReturn(Optional.empty());

        DescriptionNotFoundException thrown = assertThrows(DescriptionNotFoundException.class, () -> {
            categoryJpaAdapter.saveCategory(categoryWithEmptyDescription);
        });

        assertNotNull(thrown);
        verify(categoryRepository, times(1)).findByName(categoryName);
    }

    @Test
    void getCategory_ByName() {
        when(categoryRepository.findByName(categoryName)).thenReturn(Optional.of(categoryEntity));
        when(categoryMapper.toCategory(categoryEntity)).thenReturn(category);

        Category foundCategory = categoryJpaAdapter.getCategory(categoryName);

        assertNotNull(foundCategory);
        assertEquals(categoryName, foundCategory.getName());
        verify(categoryRepository, times(1)).findByName(categoryName);
        verify(categoryMapper, times(1)).toCategory(categoryEntity);
    }

    @Test
    void getCategory_ByName_NotFound() {
        when(categoryRepository.findByName(categoryName)).thenReturn(Optional.empty());

        CategoryNotFoundException thrown = assertThrows(CategoryNotFoundException.class, () -> {
            categoryJpaAdapter.getCategory(categoryName);
        });

        assertNotNull(thrown);
        verify(categoryRepository, times(1)).findByName(categoryName);
    }

    @Test
    void getCategory_ById() {
        when(categoryRepository.findById(categoryId)).thenReturn(Optional.of(categoryEntity));
        when(categoryMapper.toCategory(categoryEntity)).thenReturn(category);

        Category foundCategory = categoryJpaAdapter.getCategory(categoryId);

        assertNotNull(foundCategory);
        assertEquals(categoryId, foundCategory.getId());
        verify(categoryRepository, times(1)).findById(categoryId);
        verify(categoryMapper, times(1)).toCategory(categoryEntity);
    }

    @Test
    void getCategory_ById_NotFound() {
        when(categoryRepository.findById(categoryId)).thenReturn(Optional.empty());

        CategoryNotFoundException thrown = assertThrows(CategoryNotFoundException.class, () -> {
            categoryJpaAdapter.getCategory(categoryId);
        });

        assertNotNull(thrown);
        verify(categoryRepository, times(1)).findById(categoryId);
    }
    
}
