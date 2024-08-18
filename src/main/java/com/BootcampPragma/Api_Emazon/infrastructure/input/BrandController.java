package com.BootcampPragma.Api_Emazon.infrastructure.input;

import com.BootcampPragma.Api_Emazon.application.dto.BrandDto;
import com.BootcampPragma.Api_Emazon.application.service.BrandService;
import lombok.RequiredArgsConstructor;
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

}
