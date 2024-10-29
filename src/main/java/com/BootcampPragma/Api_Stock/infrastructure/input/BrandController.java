package com.BootcampPragma.Api_Stock.infrastructure.input;

import com.BootcampPragma.Api_Stock.application.dto.BrandDto;
import com.BootcampPragma.Api_Stock.application.service.BrandService;
import com.BootcampPragma.Api_Stock.infrastructure.Utils.InfraConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(InfraConstants.BRAND)
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @PostMapping
    @PreAuthorize(InfraConstants.HAS_ROLE_ADMIN)
    private void saveBrand(@RequestBody BrandDto brand){
         brandService.saveBrand(brand);
    }

    @GetMapping
    private ResponseEntity<Page<BrandDto>> getCategories(
            @RequestParam (defaultValue = InfraConstants.ORDER) String order,
            @RequestParam(defaultValue = InfraConstants.ZERO) int page,
            @RequestParam(defaultValue = InfraConstants.TEN) int size) {
        return ResponseEntity.ok(brandService.getBrandsOrderedByName(order, page, size));
    }

    @GetMapping(InfraConstants.LIST)
    private ResponseEntity<List<BrandDto>> getBrandList(){
        return ResponseEntity.ok(brandService.getBrandList());
    }

}
