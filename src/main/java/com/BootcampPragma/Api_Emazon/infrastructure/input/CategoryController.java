package com.BootcampPragma.Api_Emazon.infrastructure.input;

import com.BootcampPragma.Api_Emazon.application.dto.CategoryDto;
import com.BootcampPragma.Api_Emazon.application.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    private void saveCategory(@RequestBody CategoryDto category){
        categoryService.saveCategory(category);
    }

    @GetMapping
    private List<CategoryDto> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/asc")
    public Page<CategoryDto> getCategoriesAsc(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return categoryService.getCategoriesOrderedByNameAsc(page, size);
    }

    @GetMapping("/desc")
    public Page<CategoryDto> getCategoriesDesc(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return categoryService.getCategoriesOrderedByNameDesc(page, size);
    }


}
