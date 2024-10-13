package com.BootcampPragma.Api_Stock.domain.Utils;

import com.BootcampPragma.Api_Stock.domain.exeption.*;
import com.BootcampPragma.Api_Stock.domain.model.Brand;
import com.BootcampPragma.Api_Stock.domain.model.Category;
import com.BootcampPragma.Api_Stock.domain.model.Item;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Validation {

    private static void validateName(String name,int length) {
        if (name == null || name.isEmpty()) {
            throw new NameNotFoundException();
        }
        if (name.length() > length) {
            throw new NameIsTooLongException();
        }
    }
    private static void validateDescription(String name,int length) {
        if (name == null || name.isEmpty()) {
            throw new DescriptionNotFoundException();
        }
        if (name.length() > length) {
            throw new DescriptionIsTooLongException();
        }
    }

    private static void validateCreation(Object objeto) {
        if (objeto != null) {

            if (objeto instanceof Brand) {
                throw new BrandAlreadyExistsException();

            } else if (objeto instanceof Item) {
                throw new ItemAlreadyExistsException();

            } else if (objeto instanceof Category) {
                throw new CategoryAlreadyExistsException();

            } else {
                throw new IllegalArgumentException();
            }
        }
    }
    private static void validateUniqueCategory(List<Category> categoryList) {
        Set<Long> uniqueCategories = categoryList.stream()
                .map(Category::getId)
                .collect(Collectors.toSet());
        if (categoryList.size() != uniqueCategories.size()) {
            throw new CategoryListDuplicateExeption();
        }
    }
    private static void validateCategory(List<Category> categoryList) {
        for (Category category : categoryList) {
            if (category == null) {
                throw new CategoryNotFoundException();
            }
        }
    }
    private static void validateBrand(Brand brand) {
        if (brand == null){
            throw new BrandNotFoundException();
        }
    }

    public static void validate(Category creation, Category repository){
        validateName(creation.getName(), DomConstant.NAME);
        validateDescription(creation.getDescription(), DomConstant.DESCRIPTION_1);
        validateCreation(repository);
    }
    public static void validate(Brand creation, Brand repository){
        validateName(creation.getName(),DomConstant.NAME);
        validateDescription(creation.getDescription(), DomConstant.DESCRIPTION_2);
        validateCreation(repository);
    }
    public static void validate(Item creation, Item repository,List<Category> categoryList,Brand brand){
        validateName(creation.getName(),DomConstant.DEFAULT);
        validateDescription(creation.getDescription(),DomConstant.DEFAULT);
        validateCreation(repository);
        validateCategory(categoryList);
        validateUniqueCategory(categoryList);
        validateBrand(brand);
    }
}
