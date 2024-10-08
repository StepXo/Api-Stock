package com.BootcampPragma.Api_Stock.application.mapper;

import com.BootcampPragma.Api_Stock.application.dto.BrandDto;
import com.BootcampPragma.Api_Stock.domain.model.Brand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface BrandRequest {

    Brand toBrand(BrandDto brand);
    BrandDto toBrandDto(Brand brandDto);

}
