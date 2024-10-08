package com.BootcampPragma.Api_Stock.infrastructure.input;

import com.BootcampPragma.Api_Stock.application.dto.BrandDto;
import com.BootcampPragma.Api_Stock.application.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brand")
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;



    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    private void saveBrand(@RequestBody BrandDto brand){
         brandService.saveBrand(brand);
    }

    @GetMapping("/{order}")
    private Page<BrandDto> getCategories(
            @PathVariable String order,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return brandService.getBrandsOrderedByName(order, page, size);
    }

}
