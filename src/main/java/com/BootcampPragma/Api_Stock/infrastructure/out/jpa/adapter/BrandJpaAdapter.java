package com.BootcampPragma.Api_Stock.infrastructure.out.jpa.adapter;

import com.BootcampPragma.Api_Stock.domain.model.Brand;
import com.BootcampPragma.Api_Stock.domain.spi.BrandPersistencePort;
import com.BootcampPragma.Api_Stock.infrastructure.out.jpa.entity.BrandEntity;
import com.BootcampPragma.Api_Stock.infrastructure.out.jpa.mapper.BrandMapper;
import com.BootcampPragma.Api_Stock.infrastructure.out.jpa.repository.BrandRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class BrandJpaAdapter implements BrandPersistencePort {

    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    @Override
    public List<Brand> getAllBrands() {
        return brandRepository
                .findAll()
                .stream()
                .map(brandMapper::toBrand)
                .toList();
    }

    @Override
    public Brand saveBrand(Brand brand){

        BrandEntity brandEntity = this.brandRepository.save(
                brandMapper.toBrandEntity(brand));
        return brandMapper.toBrand(brandEntity);
    }

    @Override
    public Brand getBrand(String name) {
        return brandRepository.findByName(name)
                .map(brandMapper::toBrand)
                .orElse(null);
    }

    @Override
    public Brand getBrand(long id){
        return brandRepository.findById(id)
                .map(brandMapper::toBrand)
                .orElse(null);    }

    @Override
    public void updateBrand(Brand brand){
        this.brandRepository.save(
                brandMapper.toBrandEntity(brand));
    }

    @Override
    public void deleteBrand(String marcaId){
        brandRepository.deleteByName(marcaId);}


}
