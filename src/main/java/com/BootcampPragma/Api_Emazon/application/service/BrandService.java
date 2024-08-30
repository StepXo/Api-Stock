package com.BootcampPragma.Api_Emazon.application.service;

import com.BootcampPragma.Api_Emazon.application.dto.BrandDto;
import com.BootcampPragma.Api_Emazon.application.mapper.BrandRequest;
import com.BootcampPragma.Api_Emazon.application.util.PaginationUtil;
import com.BootcampPragma.Api_Emazon.application.util.SorterUtil;
import com.BootcampPragma.Api_Emazon.domain.api.BrandServicePort;
import com.BootcampPragma.Api_Emazon.domain.model.Brand;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BrandService {

    private final BrandRequest brandRequest;
    private  final BrandServicePort brandServicePort;
    private final SorterUtil sorterUtil;
    private final PaginationUtil paginationUtil;

    public Page<BrandDto> getBrandsOrderedByName(String order, int page, int size) {
        List<BrandDto> brandDto = brandServicePort
                .getAllBrands()
                .stream()
                .map(brandRequest::toBrandDto)
                .toList();

        List<BrandDto> sortedBrandDto = sorterUtil.getSortedBrands(order,brandDto);
        return paginationUtil.getBrandsPagination(order, page, size, sortedBrandDto);
    }



    public void saveBrand(BrandDto brandDto){
        Brand brand = brandRequest.toBrand(brandDto);
        brandServicePort.saveBrand(brand);
    }
    
}
