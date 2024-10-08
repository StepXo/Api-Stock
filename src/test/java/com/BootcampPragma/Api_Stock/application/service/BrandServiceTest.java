package com.BootcampPragma.Api_Stock.application.service;

import com.BootcampPragma.Api_Stock.application.dto.BrandDto;
import com.BootcampPragma.Api_Stock.application.mapper.BrandRequest;
import com.BootcampPragma.Api_Stock.application.util.PaginationUtil;
import com.BootcampPragma.Api_Stock.application.util.SorterUtil;
import com.BootcampPragma.Api_Stock.domain.api.BrandServicePort;
import com.BootcampPragma.Api_Stock.domain.model.Brand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;


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
    @Mock
    private SorterUtil sorterUtil;

    @Mock
    private PaginationUtil paginationUtil;

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
        // Configurar los mocks
        when(brandServicePort.getAllBrands()).thenReturn(List.of(brand, brand2));
        when(brandRequest.toBrandDto(brand)).thenReturn(brandDto);
        when(brandRequest.toBrandDto(brand2)).thenReturn(brandDto2);
        when(sorterUtil.getSortedBrands("asc", List.of(brandDto, brandDto2)))
                .thenReturn(List.of(brandDto, brandDto2)); // Ajusta según la lógica esperada

        Page<BrandDto> pagedResult = new PageImpl<>(List.of(brandDto, brandDto2), PageRequest.of(0, 10), 2);
        when(paginationUtil.getBrandsPagination("asc", 0, 10, List.of(brandDto, brandDto2)))
                .thenReturn(pagedResult);

        Page<BrandDto> result = brandService.getBrandsOrderedByName("asc", 0, 10);

        assertNotNull(result);
        assertEquals(2, result.getContent().size(), "The number of categories in the result should be 2");
        assertEquals("Books", result.getContent().get(0).getName(), "The first brand should be 'Books'");
        assertEquals("Electronics", result.getContent().get(1).getName(), "The second brand should be 'Electronics'");
    }

    @Test
    void testGetBrandsOrderedByName_Negative() {
        when(brandServicePort.getAllBrands()).thenReturn(List.of());
        when(sorterUtil.getSortedBrands("asc", List.of()))
                .thenReturn(List.of()); // Ajusta según la lógica esperada

        Page<BrandDto> pagedResult = new PageImpl<>(List.of(), PageRequest.of(0, 10), 0);
        when(paginationUtil.getBrandsPagination("asc", 0, 10, List.of()))
                .thenReturn(pagedResult);

        Page<BrandDto> result = brandService.getBrandsOrderedByName("asc", 0, 10);

        assertNotNull(result);
        assertTrue(result.getContent().isEmpty());
    }
}
