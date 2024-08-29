package com.BootcampPragma.Api_Emazon.domain.spi;

import com.BootcampPragma.Api_Emazon.domain.model.Brand;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BrandPersistencePort {
    Brand saveBrand(Brand brand);

    List<Brand> getAllBrands();
    public Brand getBrand(String name);
    void updateBrand(Brand brand);

    void deleteBrand(String marcaId);

}
