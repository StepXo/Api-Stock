package com.BootcampPragma.Api_Emazon.application.service;

import com.BootcampPragma.Api_Emazon.application.dto.BrandDto;
import com.BootcampPragma.Api_Emazon.application.mapper.BrandRequest;
import com.BootcampPragma.Api_Emazon.domain.api.BrandServicePort;
import com.BootcampPragma.Api_Emazon.domain.model.Brand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BrandServiceTest {

    @Mock
    private BrandServicePort brandServicePort;

    @Mock
    private BrandRequest brandRequest;

    @InjectMocks
    private BrandService brandService;

    private BrandDto brandDto;
    private BrandDto brandDto2;

    private Brand brand;
    private Brand brand2;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        brandDto = new BrandDto(1, "Books", "Books Brand");        brandDto = new BrandDto(1, "Books", "Books Brand");
        brandDto2 = new BrandDto(2, "Electronics", "Electronics Brand");
        brand = new Brand(1, "Books", "Books Brand");
        brand2 = new Brand(2, "Electronics", "Electronics Brand");

    }

    @Test
    void testSaveBrand_Positive() {

        when(brandRequest.toBrand(brandDto)).thenReturn(brand);
        assertDoesNotThrow(() -> brandService.saveBrand(brandDto));

        verify(brandRequest, times(1)).toBrand(brandDto); // Verifica que se llame a toBrand
        verify(brandServicePort, times(1)).saveBrand(brand); // Verifica que se llame a saveBrand
    }

    @Test
    void testGetBrandsOrderedByName_Positive() {
        when(brandServicePort.getAllBrands()).thenReturn(List.of(brand, brand2));
        when(brandRequest.toBrandDto(brand)).thenReturn(brandDto);
        when(brandRequest.toBrandDto(brand2)).thenReturn(brandDto2);

        Page<BrandDto> result = brandService.getBrandsOrderedByName("asc", 0, 10);

        assertNotNull(result);
        assertEquals(2, result.getContent().size(), "The number of brands in the result should be 2");
        assertEquals("Books", result.getContent().get(0).getName(), "The first brand should be 'Books'");
        assertEquals("Electronics", result.getContent().get(1).getName(), "The second brand should be 'Electronics'");
    }

    @Test
    void testGetBrandsOrderedByName_Negative() {
        int page = 0, size = 10;

        when(brandServicePort.getAllBrands()).thenReturn(List.of());

        Page<BrandDto> result = brandService.getBrandsOrderedByName("asc", page, size);

        assertNotNull(result);
        assertTrue(result.getContent().isEmpty());
    }
}
