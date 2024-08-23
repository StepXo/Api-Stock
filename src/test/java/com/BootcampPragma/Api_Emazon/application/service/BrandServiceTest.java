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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class BrandServiceTest {

    @Mock
    private BrandServicePort brandServicePort;

    @Mock
    private BrandRequest brandRequest;

    @InjectMocks
    private BrandService brandService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveBrand_Positive() {
        BrandDto brandDto = new BrandDto(1, "Books", "Books Brand");
        Brand brand = new Brand(1, "Books", "Books Brand");

        when(brandRequest.toBrand(brandDto)).thenReturn(brand);
        doNothing().when(brandServicePort).saveBrand(brand);

        assertDoesNotThrow(() -> brandService.saveBrand(brandDto));

        verify(brandRequest, times(1)).toBrand(brandDto); // Verifica que se llame a toBrand
        verify(brandServicePort, times(1)).saveBrand(brand); // Verifica que se llame a saveBrand
    }

    @Test
    void testGetBrandsOrderedByName_Positive() {
        Brand brand1 = new Brand(1, "Books", "Books Brand");
        Brand brand2 = new Brand(2, "Electronics", "Electronics Brand");

        when(brandServicePort.getAllBrands()).thenReturn(List.of(brand1, brand2));
        when(brandRequest.toBrandDto(brand1)).thenReturn(new BrandDto(1, "Books", "Books Brand"));
        when(brandRequest.toBrandDto(brand2)).thenReturn(new BrandDto(2, "Electronics", "Electronics Brand"));

        Page<BrandDto> result = brandService.getBrandsOrderedByName("asc", 0, 10);

        assertNotNull(result);
        assertEquals(2, result.getContent().size(), "The number of brands in the result should be 2");
        assertEquals("Books", result.getContent().get(0).getName(), "The first brand should be 'Books'");
        assertEquals("Electronics", result.getContent().get(1).getName(), "The second brand should be 'Electronics'");
    }

    @Test
    void testGetBrandsOrderedByName_Negative() {
        int page = 0, size = 10;
        Pageable pageable = PageRequest.of(page, size);

        when(brandServicePort.getAllBrands()).thenReturn(List.of());

        Page<BrandDto> result = brandService.getBrandsOrderedByName("asc", page, size);

        assertNotNull(result);
        assertTrue(result.getContent().isEmpty());
    }
}
