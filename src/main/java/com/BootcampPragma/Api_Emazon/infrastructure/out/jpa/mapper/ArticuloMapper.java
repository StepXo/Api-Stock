package com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.mapper;

import com.BootcampPragma.Api_Emazon.application.dto.ArticuloDto;
import com.BootcampPragma.Api_Emazon.domain.model.Articulo;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.entity.ArticuloEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ArticuloMapper {
    Articulo toArticulo(ArticuloEntity articulo);
    ArticuloEntity toArticuloEntity(Articulo articulo);
}
