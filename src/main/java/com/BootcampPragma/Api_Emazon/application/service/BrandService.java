package com.BootcampPragma.Api_Emazon.application.service;

import com.BootcampPragma.Api_Emazon.application.dto.BrandDto;
import com.BootcampPragma.Api_Emazon.application.mapper.BrandRequest;
import com.BootcampPragma.Api_Emazon.domain.api.BrandServicePort;
import com.BootcampPragma.Api_Emazon.domain.model.Brand;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class BrandService {

    private final BrandRequest brandRequest;
    private  final BrandServicePort brandServicePort;

    public List<BrandDto> getAllBrands() {
        return brandServicePort
                .getAllBrands()
                .stream()
                .map(brandRequest::toBrandDto)
                .collect(Collectors.toList()
                );
    }

    public void saveBrand(BrandDto brandDto){
        Brand brand = brandRequest.toBrand(brandDto);
        brandServicePort.saveBrand(brand);
    }

}
