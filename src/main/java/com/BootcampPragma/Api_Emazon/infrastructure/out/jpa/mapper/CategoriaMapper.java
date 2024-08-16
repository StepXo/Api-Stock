package com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.mapper;

import com.BootcampPragma.Api_Emazon.domain.model.Categoria;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.entity.CategoriaEntity;
import  org.mapstruct.Mapper;


@Mapper(componentModel = "Strping")
public interface CategoriaMapper {

    Categoria toCategoria(CategoriaEntity categoria);
    CategoriaEntity toCategoriaEntity(Categoria categoria);
}
