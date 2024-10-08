package com.BootcampPragma.Api_Stock.domain.api;

import com.BootcampPragma.Api_Stock.domain.model.Brand;

import java.util.List;

public interface BrandServicePort {

        Brand saveBrand(Brand brand);
        public Brand getBrand(String name);
        List<Brand> getAllBrands();

        void updateBrand(Brand brand);

        void deleteBrand(String brandId);

}
