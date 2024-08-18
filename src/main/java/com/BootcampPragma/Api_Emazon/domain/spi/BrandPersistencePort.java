package com.BootcampPragma.Api_Emazon.domain.spi;

import com.BootcampPragma.Api_Emazon.domain.model.Brand;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.entity.BrandEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BrandPersistencePort {
    Brand saveBrand(Brand brand);

    List<Brand> getAllBrands();

    void updateBrand(Brand brand);

    void deleteBrand(String marcaId);
    Page<Brand> findAllByOrderByNameAsc(Pageable pageable);
    Page<Brand> findAllByOrderByNameDesc(Pageable pageable);
}
