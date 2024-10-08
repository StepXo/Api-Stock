package com.BootcampPragma.Api_Stock.domain.usecase;

import com.BootcampPragma.Api_Stock.domain.api.CategoryServicePort;
import com.BootcampPragma.Api_Stock.domain.model.Category;
import com.BootcampPragma.Api_Stock.domain.exeption.DescriptionIsTooLongException;
import com.BootcampPragma.Api_Stock.domain.exeption.NameIsTooLongException;
import com.BootcampPragma.Api_Stock.domain.spi.CategoryPersistencePort;

import java.util.List;

public class CategoryHU implements CategoryServicePort {

    private final CategoryPersistencePort categoryPersistencePort;

    public CategoryHU(CategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public Category saveCategory(Category category) {

        if (category.getName().length() > 50) {
            throw new NameIsTooLongException();
        } else if (category.getDescription().length() > 90) {
            throw new DescriptionIsTooLongException();
        }
        return categoryPersistencePort.saveCategory(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryPersistencePort.getAllCategories();
    }

    @Override
    public void updateCategory(Category category) {
        if (category.getName().length() > 50) {
            throw new NameIsTooLongException();
        } else if (category.getDescription().length() > 90) {
            throw new DescriptionIsTooLongException();
        }
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
