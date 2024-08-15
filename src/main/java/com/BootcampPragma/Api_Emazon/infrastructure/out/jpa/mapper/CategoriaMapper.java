package com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.mapper;
import com.BootcampPragma.Api_Emazon.application.dto.CategoriaDto;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.entity.CategoriaEntity;
import  org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CategoriaMapper {
    CategoriaDto categoriaDtoToCategoriaEntity(CategoriaEntity categoria);
    CategoriaEntity categoriaEntityToCategoriaDto (CategoriaDto categoria);
}
