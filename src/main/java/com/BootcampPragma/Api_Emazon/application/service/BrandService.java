package com.BootcampPragma.Api_Emazon.application.service;

import com.BootcampPragma.Api_Emazon.application.dto.BrandDto;
import com.BootcampPragma.Api_Emazon.application.mapper.BrandRequest;
import com.BootcampPragma.Api_Emazon.domain.api.BrandServicePort;
import com.BootcampPragma.Api_Emazon.domain.model.Brand;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BrandService {

    private final BrandRequest brandRequest;
    private  final BrandServicePort brandServicePort;

    public Page<BrandDto> getBrandsOrderedByName(String order, int page, int size) {

        Sort sort = "asc".equalsIgnoreCase(order)
                ? Sort.by("name").descending()
                : Sort.by("name").ascending();
        Pageable pageable = PageRequest.of(page, size, sort);

        List<BrandDto> brandDto = brandServicePort
                .getAllBrands()
                .stream()
                .map(brandRequest::toBrandDto)
                .toList();

        Comparator<BrandDto> comparator = "asc".equalsIgnoreCase(order)
                ? Comparator.comparing(BrandDto::getName)
                : Comparator.comparing(BrandDto::getName).reversed();

        List<BrandDto> sortedBrandDto = brandDto.stream()
                .sorted(comparator)
                .toList();

        int start = (int) pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize(), sortedBrandDto.size());

        return new PageImpl<>(sortedBrandDto.subList(start, end), pageable, sortedBrandDto.size());
    }

    public void saveBrand(BrandDto brandDto){
        Brand brand = brandRequest.toBrand(brandDto);
        brandServicePort.saveBrand(brand);
    }
    
}
