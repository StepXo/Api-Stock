package com.BootcampPragma.Api_Emazon.application.mapper;

import com.BootcampPragma.Api_Emazon.application.dto.BrandDto;
import com.BootcampPragma.Api_Emazon.domain.model.Brand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface BrandRequest {

    Brand toBrand(BrandDto brand);
    BrandDto toBrandDto(Brand brandDto);

}
