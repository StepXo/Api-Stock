package com.BootcampPragma.Api_Emazon.domain.api;

import com.BootcampPragma.Api_Emazon.domain.model.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BrandServicePort {

        Brand saveBrand(Brand brand);

        List<Brand> getAllBrands();

        void updateBrand(Brand brand);

        void deleteBrand(String brandId);
        Page<Brand> findAllByOrderByNameAsc(Pageable pageable);
        Page<Brand> findAllByOrderByNameDesc(Pageable pageable);
}
