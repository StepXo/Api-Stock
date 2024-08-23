package com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.adapter;

import com.BootcampPragma.Api_Emazon.domain.model.Category;
import com.BootcampPragma.Api_Emazon.domain.spi.CategoryPersistencePort;
import com.BootcampPragma.Api_Emazon.infrastructure.exeption.CategoryAlreadyExistsException;
import com.BootcampPragma.Api_Emazon.infrastructure.exeption.DescriptionNotFoundException;
import com.BootcampPragma.Api_Emazon.infrastructure.exeption.NoDataFoundException;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.entity.CategoryEntity;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.mapper.CategoryMapper;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
public class CategoryJpaAdapter implements CategoryPersistencePort {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<Category> getAllCategories() {

        List<CategoryEntity> categoryEntityList = categoryRepository.findAll();
        if (categoryEntityList.isEmpty()){throw new NoDataFoundException();}

        return categoryRepository
                .findAll()
                .stream()
                .map(categoryMapper::toCategory)
                .collect(Collectors.toList()
                );
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
    public void updateCategory(Category category){

        if (categoryRepository.findByName(category.getName()).isPresent()){
            throw new CategoryAlreadyExistsException();
        } else if (category.getDescription().isEmpty()){
            throw new DescriptionNotFoundException();
        }
        CategoryEntity categoryEntity = this.categoryRepository.save(
                categoryMapper.toCategoryEntity(category));
    };

    @Override
    public void deleteCategory(String categoryId){
        categoryRepository.deleteByName(categoryId);}

}
