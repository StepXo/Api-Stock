package com.BootcampPragma.Api_Stock.infrastructure.out.jpa.adapter;

import com.BootcampPragma.Api_Stock.domain.model.Brand;
import com.BootcampPragma.Api_Stock.domain.spi.BrandPersistencePort;
import com.BootcampPragma.Api_Stock.domain.exeption.BrandAlreadyExistsException;
import com.BootcampPragma.Api_Stock.domain.exeption.BrandNotFoundException;
import com.BootcampPragma.Api_Stock.domain.exeption.DescriptionNotFoundException;
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

        if (brandRepository.findByName(brand.getName()).isPresent()){
            throw new BrandAlreadyExistsException();
        } else if (brand.getDescription().isEmpty()){
            throw new DescriptionNotFoundException();
        }

        BrandEntity brandEntity = this.brandRepository.save(
                brandMapper.toBrandEntity(brand)
        );
        return brandMapper.toBrand(brandEntity);
    }
    @Override
    public Brand getBrand(String name) {
        return brandMapper.toBrand(brandRepository.findByName(name)
                .orElseThrow(BrandNotFoundException::new));
    }
    public Brand getBrand(Long id) {
        return brandMapper.toBrand(brandRepository.findById(id)
                .orElseThrow(BrandNotFoundException::new));
    }

    @Override
    public void updateBrand(Brand brand){

        if (brandRepository.findByName(brand.getName()).isPresent()){
            throw new BrandAlreadyExistsException();
        } else if (brand.getDescription().isEmpty()){
            throw new DescriptionNotFoundException();
        }
        this.brandRepository.save(
                brandMapper.toBrandEntity(brand));
    };

    @Override
    public void deleteBrand(String marcaId){
        brandRepository.deleteByName(marcaId);}


}
