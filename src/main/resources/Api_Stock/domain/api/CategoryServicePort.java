package com.BootcampPragma.Api_Stock.domain.api;

import com.BootcampPragma.Api_Stock.domain.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryServicePort {

        Category saveCategory(Category category);

        List<Category> getAllCategories();

        void updateCategory(Category category);

        void deleteCategory(String categoryId);

        Page<Category> findAllByOrderByNameAsc(Pageable pageable);
        Page<Category> findAllByOrderByNameDesc(Pageable pageable);
}
