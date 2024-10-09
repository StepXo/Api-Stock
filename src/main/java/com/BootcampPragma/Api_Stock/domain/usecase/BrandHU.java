package com.BootcampPragma.Api_Stock.domain.usecase;

import com.BootcampPragma.Api_Stock.domain.Utils.Validation;
import com.BootcampPragma.Api_Stock.domain.api.BrandServicePort;
import com.BootcampPragma.Api_Stock.domain.exeption.DescriptionIsTooLongException;
import com.BootcampPragma.Api_Stock.domain.exeption.NameIsTooLongException;
import com.BootcampPragma.Api_Stock.domain.model.Brand;
import com.BootcampPragma.Api_Stock.domain.spi.BrandPersistencePort;

import java.util.List;

public class BrandHU implements BrandServicePort {

    private final BrandPersistencePort brandPersistencePort;

    public BrandHU(BrandPersistencePort brandPersistencePort) {
        this.brandPersistencePort = brandPersistencePort;
    }

    @Override
    public Brand saveBrand(Brand brand) {

        Brand repository = brandPersistencePort.getBrand(brand.getName());
        Validation.validate(brand,repository);

        return brandPersistencePort.saveBrand(brand);
    }

    @Override
    public List<Brand> getAllBrands() {
        return brandPersistencePort.getAllBrands();
    }

    @Override
    public void updateBrand(Brand brand) {

        Brand repository = brandPersistencePort.getBrand(brand.getName());
        Validation.validate(brand,repository);

        brandPersistencePort.saveBrand(brand);
    }

    @Override
    public Brand getBrand(String name){
        return brandPersistencePort.getBrand(name);
    }


    @Override
    public void deleteBrand(String brandId) {
    }


}
