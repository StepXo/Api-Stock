package com.BootcampPragma.Api_Stock.infrastructure.input;

import com.BootcampPragma.Api_Stock.application.dto.BrandDto;
import com.BootcampPragma.Api_Stock.application.service.BrandService;
import com.BootcampPragma.Api_Stock.infrastructure.Utils.InfraConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(InfraConstants.BRAND_PATH)
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;



    @PostMapping
    @PreAuthorize(InfraConstants.HAS_ROLE_ADMIN)
    private void saveBrand(@RequestBody BrandDto brand){
         brandService.saveBrand(brand);
    }

    @GetMapping(InfraConstants.ORDER)
    private Page<BrandDto> getCategories(
            @PathVariable String order,
            @RequestParam(defaultValue = InfraConstants.ZERO) int page,
            @RequestParam(defaultValue = InfraConstants.TEN) int size) {
        return brandService.getBrandsOrderedByName(order, page, size);
    }

}
