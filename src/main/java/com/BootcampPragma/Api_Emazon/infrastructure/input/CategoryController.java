package com.BootcampPragma.Api_Emazon.infrastructure.input;

import com.BootcampPragma.Api_Emazon.application.dto.CategoryDto;
import com.BootcampPragma.Api_Emazon.application.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;


    @GetMapping
    private List<CategoryDto> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @PostMapping
    private void saveCategory(@RequestBody CategoryDto category){
        categoryService.saveCategory(category);
    }

}
