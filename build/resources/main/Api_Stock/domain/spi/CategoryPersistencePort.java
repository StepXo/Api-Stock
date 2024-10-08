package com.BootcampPragma.Api_Stock.domain.spi;

import com.BootcampPragma.Api_Stock.domain.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryPersistencePort {
    Category saveCategory(Category category);

    void updateCategory(Category category);

    List<Category> getAllCategories();

    void deleteCategory(String categoriaId);

    Page<Category> findAllByOrderByNameAsc(Pageable pageable);
    Page<Category> findAllByOrderByNameDesc(Pageable pageable);
}
