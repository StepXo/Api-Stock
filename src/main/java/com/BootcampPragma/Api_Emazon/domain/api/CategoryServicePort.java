package com.BootcampPragma.Api_Emazon.domain.api;

import com.BootcampPragma.Api_Emazon.domain.model.Category;

import java.util.List;

public interface CategoryServicePort {

        Category saveCategory(Category category);

        Category getCategory(String name);

        List<Category> getAllCategories();

        void updateCategory(Category category);

        void deleteCategory(String categoryId);

}
