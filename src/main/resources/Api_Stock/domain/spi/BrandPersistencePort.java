package com.BootcampPragma.Api_Stock.domain.spi;

import com.BootcampPragma.Api_Stock.domain.model.Brand;
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
