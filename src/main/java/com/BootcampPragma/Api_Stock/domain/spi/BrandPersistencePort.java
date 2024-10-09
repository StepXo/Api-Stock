package com.BootcampPragma.Api_Stock.domain.spi;

import com.BootcampPragma.Api_Stock.domain.model.Brand;

import java.util.List;

public interface BrandPersistencePort {
    Brand saveBrand(Brand brand);

    List<Brand> getAllBrands();

    Brand getBrand(String name);
    Brand getBrand(long id);

    void updateBrand(Brand brand);

    void deleteBrand(String marcaId);

}
