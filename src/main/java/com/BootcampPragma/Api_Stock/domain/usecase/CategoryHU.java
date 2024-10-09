package com.BootcampPragma.Api_Stock.domain.usecase;

import com.BootcampPragma.Api_Stock.domain.Utils.Validation;
import com.BootcampPragma.Api_Stock.domain.api.CategoryServicePort;
import com.BootcampPragma.Api_Stock.domain.model.Category;
import com.BootcampPragma.Api_Stock.domain.spi.CategoryPersistencePort;

import java.util.List;

public class CategoryHU implements CategoryServicePort {

    private final CategoryPersistencePort categoryPersistencePort;

    public CategoryHU(CategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public Category saveCategory(Category category) {

        Category repository = categoryPersistencePort.getCategory(category.getName());
        Validation.validate(category,repository);

        return categoryPersistencePort.saveCategory(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryPersistencePort.getAllCategories();
    }

    @Override
    public void updateCategory(Category category) {

        Category repository = categoryPersistencePort.getCategory(category.getName());
        Validation.validate(category,repository);

        categoryPersistencePort.saveCategory(category);
    }

    @Override
    public Category getCategory(String name){
        return categoryPersistencePort.getCategory(name);
    }

    @Override
    public void deleteCategory(String categoryId) {

    }


}
