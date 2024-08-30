package com.BootcampPragma.Api_Emazon.infrastructure.input;

import com.BootcampPragma.Api_Emazon.application.dto.BrandDto;
import com.BootcampPragma.Api_Emazon.application.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;



    @PostMapping
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
