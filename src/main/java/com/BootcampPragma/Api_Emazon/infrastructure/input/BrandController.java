package com.BootcampPragma.Api_Emazon.infrastructure.input;

import com.BootcampPragma.Api_Emazon.application.dto.BrandDto;
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


    @GetMapping
    private List<BrandDto> getAllBrands(){
        return brandService.getAllBrands();
    }

    @PostMapping
    private void saveBrand(@RequestBody BrandDto brand){
         brandService.saveBrand(brand);
    }

    @GetMapping("/asc")
    public Page<BrandDto> getBrandsAsc(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return brandService.getBrandsOrderedByNameAsc(page, size);
    }

    @GetMapping("/desc")
    public Page<BrandDto> getBrandsDesc(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return brandService.getBrandsOrderedByNameAsc(page, size);
    }

}
