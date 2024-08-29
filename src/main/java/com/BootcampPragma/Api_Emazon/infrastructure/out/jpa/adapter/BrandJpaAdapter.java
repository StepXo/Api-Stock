package com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.adapter;

import com.BootcampPragma.Api_Emazon.domain.model.Brand;
import com.BootcampPragma.Api_Emazon.domain.spi.BrandPersistencePort;
import com.BootcampPragma.Api_Emazon.infrastructure.exeption.BrandAlreadyExistsException;
import com.BootcampPragma.Api_Emazon.infrastructure.exeption.BrandNotFoundException;
import com.BootcampPragma.Api_Emazon.infrastructure.exeption.DescriptionNotFoundException;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.entity.BrandEntity;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.mapper.BrandMapper;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.repository.BrandRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;


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
                .collect(Collectors.toList()
                );
    }

    @Override
    public Brand saveBrand(Brand brand){

        if (brandRepository.findByName(brand.getName()).isPresent()){
            throw new BrandAlreadyExistsException();
        } else if (brand.getDescription().isEmpty()){
            throw new DescriptionNotFoundException();
        }

        BrandEntity brandEntity = this.brandRepository.save(
                brandMapper.toMarcaEntity(brand)
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
        BrandEntity brandEntity = this.brandRepository.save(
                brandMapper.toMarcaEntity(brand));
    };

    @Override
    public void deleteBrand(String marcaId){
        brandRepository.deleteByName(marcaId);}


}
