package com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.adapter;

import com.BootcampPragma.Api_Emazon.domain.model.Brand;
import com.BootcampPragma.Api_Emazon.infrastructure.exeption.BrandAlreadyExistsException;
import com.BootcampPragma.Api_Emazon.infrastructure.exeption.BrandNotFoundException;
import com.BootcampPragma.Api_Emazon.infrastructure.exeption.DescriptionNotFoundException;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.entity.BrandEntity;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.mapper.BrandMapper;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.repository.BrandRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BrandJpaAdapterTest {


    @Mock
    private BrandRepository brandRepository;

    @Mock
    private BrandMapper brandMapper;

    @InjectMocks
    private BrandJpaAdapter brandJpaAdapter;

    private Brand brand;
    private BrandEntity brandEntity;
    private String brandName;
    private Long brandId;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        brandName = "Test Brand";
        brandId = 1L;
        brand = new Brand(brandId, brandName, "Description");
        brandEntity = new BrandEntity(brandId, brandName, "Description");
    }
    @Test
    void getAllBrands() {
        when(brandRepository.findAll()).thenReturn(List.of(brandEntity));
        when(brandMapper.toBrand(brandEntity)).thenReturn(brand);

        List<Brand> brands = brandJpaAdapter.getAllBrands();

        assertNotNull(brands);
        assertEquals(1, brands.size());
        assertEquals(brandName, brands.get(0).getName());
        verify(brandRepository, times(1)).findAll();
        verify(brandMapper, times(1)).toBrand(brandEntity);
    }

    @Test
    void saveBrand() {
        when(brandRepository.findByName(brandName)).thenReturn(Optional.empty());
        when(brandMapper.toBrandEntity(brand)).thenReturn(brandEntity);
        when(brandRepository.save(brandEntity)).thenReturn(brandEntity);
        when(brandMapper.toBrand(brandEntity)).thenReturn(brand);

        Brand savedBrand = brandJpaAdapter.saveBrand(brand);

        assertNotNull(savedBrand);
        assertEquals(brandName, savedBrand.getName());
        verify(brandRepository, times(1)).findByName(brandName);
        verify(brandRepository, times(1)).save(brandEntity);
        verify(brandMapper, times(1)).toBrandEntity(brand);
        verify(brandMapper, times(1)).toBrand(brandEntity);
    }

    @Test
    void saveBrand_AlreadyExists() {
        when(brandRepository.findByName(brandName)).thenReturn(Optional.of(brandEntity));

        BrandAlreadyExistsException thrown = assertThrows(BrandAlreadyExistsException.class, () -> {
            brandJpaAdapter.saveBrand(brand);
        });

        assertNotNull(thrown);
        verify(brandRepository, times(1)).findByName(brandName);
    }
    @Test
    void saveBrand_DescriptionNotFound() {
        Brand brandWithEmptyDescription = new Brand(brandId, brandName, "");

        when(brandRepository.findByName(brandName)).thenReturn(Optional.empty());

        DescriptionNotFoundException thrown = assertThrows(DescriptionNotFoundException.class, () -> {
            brandJpaAdapter.saveBrand(brandWithEmptyDescription);
        });

        assertNotNull(thrown);
        verify(brandRepository, times(1)).findByName(brandName);
    }

    @Test
    void getBrand_ByName() {
        when(brandRepository.findByName(brandName)).thenReturn(Optional.of(brandEntity));
        when(brandMapper.toBrand(brandEntity)).thenReturn(brand);

        Brand foundBrand = brandJpaAdapter.getBrand(brandName);

        assertNotNull(foundBrand);
        assertEquals(brandName, foundBrand.getName());
        verify(brandRepository, times(1)).findByName(brandName);
        verify(brandMapper, times(1)).toBrand(brandEntity);
    }

    @Test
    void getBrand_ByName_NotFound() {
        when(brandRepository.findByName(brandName)).thenReturn(Optional.empty());

        BrandNotFoundException thrown = assertThrows(BrandNotFoundException.class, () -> {
            brandJpaAdapter.getBrand(brandName);
        });

        assertNotNull(thrown);
        verify(brandRepository, times(1)).findByName(brandName);
    }

    @Test
    void getBrand_ById() {
        when(brandRepository.findById(brandId)).thenReturn(Optional.of(brandEntity));
        when(brandMapper.toBrand(brandEntity)).thenReturn(brand);

        Brand foundBrand = brandJpaAdapter.getBrand(brandId);

        assertNotNull(foundBrand);
        assertEquals(brandId, foundBrand.getId());
        verify(brandRepository, times(1)).findById(brandId);
        verify(brandMapper, times(1)).toBrand(brandEntity);
    }

    @Test
    void getBrand_ById_NotFound() {
        when(brandRepository.findById(brandId)).thenReturn(Optional.empty());

        BrandNotFoundException thrown = assertThrows(BrandNotFoundException.class, () -> {
            brandJpaAdapter.getBrand(brandId);
        });

        assertNotNull(thrown);
        verify(brandRepository, times(1)).findById(brandId);
    }

}
