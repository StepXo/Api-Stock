package com.BootcampPragma.Api_Stock.domain.usecase;

import com.BootcampPragma.Api_Stock.domain.exeption.DescriptionIsTooLongException;
import com.BootcampPragma.Api_Stock.domain.exeption.NameIsTooLongException;
import com.BootcampPragma.Api_Stock.domain.model.Brand;
import com.BootcampPragma.Api_Stock.domain.spi.BrandPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BrandHUTest {

    @Mock
    private BrandPersistencePort brandPersistencePort;

    @InjectMocks
    private BrandHU brandHU;

    private Brand brand;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        brand = new Brand(1L, "Test Brand", "Description");
    }

    @Test
    void saveBrand_Success() {
        when(brandPersistencePort.saveBrand(brand)).thenReturn(brand);

        Brand savedBrand = brandHU.saveBrand(brand);

        assertNotNull(savedBrand);
        assertEquals(brand.getName(), savedBrand.getName());
        verify(brandPersistencePort, times(1)).saveBrand(brand);
    }

    @Test
    void saveBrand_NameTooLong() {
        Brand longNameBrand = new Brand(1L, "A".repeat(51), "Description");

        NameIsTooLongException thrown = assertThrows(NameIsTooLongException.class, () -> {
            brandHU.saveBrand(longNameBrand);
        });

        assertNotNull(thrown);
        verify(brandPersistencePort, never()).saveBrand(any());
    }

    @Test
    void saveBrand_DescriptionTooLong() {
        Brand longDescriptionBrand = new Brand(1L, "Brand", "A".repeat(121));

        DescriptionIsTooLongException thrown = assertThrows(DescriptionIsTooLongException.class, () -> {
            brandHU.saveBrand(longDescriptionBrand);
        });

        assertNotNull(thrown);
        verify(brandPersistencePort, never()).saveBrand(any());
    }

    @Test
    void getAllBrands() {
        when(brandPersistencePort.getAllBrands()).thenReturn(List.of(brand));

        List<Brand> brands = brandHU.getAllBrands();

        assertNotNull(brands);
        assertEquals(1, brands.size());
        assertEquals(brand.getName(), brands.get(0).getName());
        verify(brandPersistencePort, times(1)).getAllBrands();
    }

    @Test
    void updateBrand_Success() {
        when(brandPersistencePort.saveBrand(brand)).thenReturn(brand);

        assertDoesNotThrow(() -> brandHU.updateBrand(brand));

        verify(brandPersistencePort, times(1)).saveBrand(brand);
    }

    @Test
    void updateBrand_NameTooLong() {
        Brand longNameBrand = new Brand(1L, "A".repeat(51), "Description");

        NameIsTooLongException thrown = assertThrows(NameIsTooLongException.class, () -> {
            brandHU.updateBrand(longNameBrand);
        });

        assertNotNull(thrown);
        verify(brandPersistencePort, never()).saveBrand(any());
    }

    @Test
    void updateBrand_DescriptionTooLong() {
        Brand longDescriptionBrand = new Brand(1L, "Brand", "A".repeat(121));

        DescriptionIsTooLongException thrown = assertThrows(DescriptionIsTooLongException.class, () -> {
            brandHU.updateBrand(longDescriptionBrand);
        });

        assertNotNull(thrown);
        verify(brandPersistencePort, never()).saveBrand(any());
    }

    @Test
    void getBrand_Success() {
        when(brandPersistencePort.getBrand(brand.getName())).thenReturn(brand);

        Brand foundBrand = brandHU.getBrand(brand.getName());

        assertNotNull(foundBrand);
        assertEquals(brand.getName(), foundBrand.getName());
        verify(brandPersistencePort, times(1)).getBrand(brand.getName());
    }

}
