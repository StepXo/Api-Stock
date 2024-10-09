package com.BootcampPragma.Api_Stock.domain.spi;

import com.BootcampPragma.Api_Stock.domain.model.Category;

import java.util.List;

public interface CategoryPersistencePort {
    Category saveCategory(Category category);

    void updateCategory(Category category);

    Category getCategory(String name);
    Category getCategory(long id);

    List<Category> getAllCategories();

    void deleteCategory(String categoryId);

}
