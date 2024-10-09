package com.BootcampPragma.Api_Stock.infrastructure.input;

import com.BootcampPragma.Api_Stock.application.dto.CategoryDto;
import com.BootcampPragma.Api_Stock.application.service.CategoryService;
import com.BootcampPragma.Api_Stock.infrastructure.Utils.InfraConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(InfraConstants.CATEGORY_PATH)
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    @PreAuthorize(InfraConstants.HAS_ROLE_ADMIN)
    private void saveCategory(@RequestBody CategoryDto category){
        categoryService.saveCategory(category);
    }

    //@GetMapping

    @GetMapping(InfraConstants.ORDER)
    private Page<CategoryDto> getCategories(
            @PathVariable String order,
            @RequestParam(defaultValue = InfraConstants.ZERO) int page,
            @RequestParam(defaultValue = InfraConstants.TEN) int size) {
        return categoryService.getCategoriesOrderedByName(order, page, size);
    }
}

