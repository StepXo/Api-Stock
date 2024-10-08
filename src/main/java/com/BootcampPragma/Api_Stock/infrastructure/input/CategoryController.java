package com.BootcampPragma.Api_Stock.infrastructure.input;

import com.BootcampPragma.Api_Stock.application.dto.CategoryDto;
import com.BootcampPragma.Api_Stock.application.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    private void saveCategory(@RequestBody CategoryDto category){
        categoryService.saveCategory(category);
    }

    //@GetMapping

    @GetMapping("/{order}")
    private Page<CategoryDto> getCategories(
            @PathVariable String order,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return categoryService.getCategoriesOrderedByName(order, page, size);
    }
}

