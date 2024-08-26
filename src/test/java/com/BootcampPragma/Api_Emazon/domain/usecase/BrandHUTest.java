package com.BootcampPragma.Api_Emazon.domain.usecase;

import com.BootcampPragma.Api_Emazon.domain.exeption.DescriptionIsTooLongException;
import com.BootcampPragma.Api_Emazon.domain.exeption.NameIsTooLongException;
import com.BootcampPragma.Api_Emazon.domain.model.Brand;
import com.BootcampPragma.Api_Emazon.domain.spi.BrandPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BrandHUTest {

    @Mock
    private BrandPersistencePort brandPersistencePort;

    @InjectMocks
    private BrandHU brandHU;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveBrand_Positive() {
        Brand brand = new Brand(1, "Books", "Books Brand");

        when(brandPersistencePort.saveBrand(brand)).thenReturn(brand);

        Brand result = brandHU.saveBrand(brand);

        assertNotNull(result);
        assertEquals("Books", result.getName());
        verify(brandPersistencePort, times(1)).saveBrand(brand);
    }

    @Test
    void testSaveBrand_NameTooLong_Negative() {
        Brand brand = new Brand(1, "This is a very long brand name that exceeds fifty characters", "Books Brand");

        assertThrows(NameIsTooLongException.class, () -> brandHU.saveBrand(brand));
        verify(brandPersistencePort, never()).saveBrand(any());
    }

    @Test
    void testSaveBrand_DescriptionTooLong_Negative() {
        Brand brand = new Brand(1, "Books", "This is a very long description that exceeds ninety characters, and it should throw an exception, and in brand needs to be even longer");

        assertThrows(DescriptionIsTooLongException.class, () -> brandHU.saveBrand(brand));
        verify(brandPersistencePort, never()).saveBrand(any());
    }
}
