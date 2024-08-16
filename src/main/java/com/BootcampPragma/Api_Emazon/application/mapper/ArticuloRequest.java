package com.BootcampPragma.Api_Emazon.application.mapper;

import com.BootcampPragma.Api_Emazon.application.dto.ArticuloDto;
import com.BootcampPragma.Api_Emazon.domain.model.Articulo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface ArticuloRequest {

    Articulo toArticulo(ArticuloDto categoria);
    ArticuloDto toArticuloDto(Articulo categoriaDto);

}
