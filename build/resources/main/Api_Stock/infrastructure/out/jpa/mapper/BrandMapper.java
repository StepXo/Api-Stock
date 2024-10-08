package com.BootcampPragma.Api_Stock.infrastructure.out.jpa.mapper;

import com.BootcampPragma.Api_Stock.domain.model.Brand;
import com.BootcampPragma.Api_Stock.infrastructure.out.jpa.entity.BrandEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface BrandMapper {
    Brand toBrand(BrandEntity brand);
    BrandEntity toMarcaEntity(Brand brand);
}
