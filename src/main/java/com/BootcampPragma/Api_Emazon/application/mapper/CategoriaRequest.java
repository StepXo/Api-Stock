package com.BootcampPragma.Api_Emazon.application.mapper;

import com.BootcampPragma.Api_Emazon.application.dto.CategoriaDto;
import com.BootcampPragma.Api_Emazon.domain.model.Categoria;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface CategoriaRequest {

    Categoria toCategoria(CategoriaDto categoria);
    CategoriaDto toCategoriaDto(Categoria categoriaDto);

}
