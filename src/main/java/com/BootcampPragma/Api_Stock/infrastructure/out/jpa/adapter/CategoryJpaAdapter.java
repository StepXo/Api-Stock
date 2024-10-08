package com.BootcampPragma.Api_Stock.infrastructure.out.jpa.adapter;

import com.BootcampPragma.Api_Stock.domain.model.Category;
import com.BootcampPragma.Api_Stock.domain.spi.CategoryPersistencePort;
import com.BootcampPragma.Api_Stock.domain.exeption.CategoryAlreadyExistsException;
import com.BootcampPragma.Api_Stock.domain.exeption.DescriptionNotFoundException;
import com.BootcampPragma.Api_Stock.domain.exeption.CategoryNotFoundException;
import com.BootcampPragma.Api_Stock.infrastructure.out.jpa.entity.CategoryEntity;
import com.BootcampPragma.Api_Stock.infrastructure.out.jpa.mapper.CategoryMapper;
import com.BootcampPragma.Api_Stock.infrastructure.out.jpa.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CategoryJpaAdapter implements CategoryPersistencePort {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<Category> getAllCategories() {

        return categoryRepository
                .findAll()
                .stream()
                .map(categoryMapper::toCategory)
                .toList();
    }

    @Override
    public Category saveCategory(Category category){

        if (categoryRepository.findByName(category.getName()).isPresent()){
            throw new CategoryAlreadyExistsException();
        } else if (category.getDescription().isEmpty()){
            throw new DescriptionNotFoundException();
        }

        CategoryEntity categoryEntity = this.categoryRepository.save(
                categoryMapper.toCategoryEntity(category)
        );
        return categoryMapper.toCategory(categoryEntity);
    }

    @Override
    public Category getCategory(String name) {
        return categoryMapper.toCategory(categoryRepository.findByName(name)
                .orElseThrow(CategoryNotFoundException::new));
    }
    public Category getCategory(Long id) {
        return categoryMapper.toCategory(categoryRepository.findById(id)
                .orElseThrow(CategoryNotFoundException::new));
    }

    @Override
    public void updateCategory(Category category){

        if (categoryRepository.findByName(category.getName()).isPresent()){
            throw new CategoryAlreadyExistsException();
        } else if (category.getDescription().isEmpty()){
            throw new DescriptionNotFoundException();
        }
        this.categoryRepository.save(
                categoryMapper.toCategoryEntity(category));
    }

    @Override
    public void deleteCategory(String categoryId){
        categoryRepository.deleteByName(categoryId);}

}
