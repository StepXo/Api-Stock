package com.BootcampPragma.Api_Emazon.domain.usecase;

import com.BootcampPragma.Api_Emazon.domain.api.BrandServicePort;
import com.BootcampPragma.Api_Emazon.domain.exeption.DescriptionIsTooLongException;
import com.BootcampPragma.Api_Emazon.domain.exeption.NameIsTooLongException;
import com.BootcampPragma.Api_Emazon.domain.model.Brand;
import com.BootcampPragma.Api_Emazon.domain.spi.BrandPersistencePort;

import java.util.List;

public class BrandHU implements BrandServicePort {

    private final BrandPersistencePort brandPersistencePort;

    public BrandHU(BrandPersistencePort brandPersistencePort) {
        this.brandPersistencePort = brandPersistencePort;
    }

    @Override
    public Brand saveBrand(Brand brand) {

        if (brand.getName().length() > 50) {
            throw new NameIsTooLongException();
        } else if (brand.getDescription().length() > 120) {
            throw new DescriptionIsTooLongException();
        }
        return brandPersistencePort.saveBrand(brand);
    }

    @Override
    public List<Brand> getAllBrands() {
        return brandPersistencePort.getAllBrands();
    }

    @Override
    public void updateBrand(Brand brand) {
        if (brand.getName().length() > 50) {
            throw new NameIsTooLongException();
        } else if (brand.getDescription().length() > 120) {
            throw new DescriptionIsTooLongException();
        }
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
