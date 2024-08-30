package com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.mapper;

import com.BootcampPragma.Api_Emazon.domain.model.Brand;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.entity.BrandEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface BrandMapper {
    Brand toBrand(BrandEntity brand);
    BrandEntity toBrandEntity(Brand brand);
}
