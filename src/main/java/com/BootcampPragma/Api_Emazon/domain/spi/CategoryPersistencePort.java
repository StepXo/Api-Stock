package com.BootcampPragma.Api_Emazon.domain.spi;

import com.BootcampPragma.Api_Emazon.domain.model.Category;

import java.util.List;

public interface CategoryPersistencePort {
    Category saveCategory(Category category);

    void updateCategory(Category category);

    List<Category> getAllCategories();

    void deleteCategory(String categoriaId);
}
