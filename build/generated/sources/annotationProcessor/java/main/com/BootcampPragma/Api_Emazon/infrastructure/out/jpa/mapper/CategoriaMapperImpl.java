package com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.mapper;

import com.BootcampPragma.Api_Emazon.application.dto.CategoriaDto;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.entity.CategoriaEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-15T23:16:39-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.12 (Amazon.com Inc.)"
)
public class CategoriaMapperImpl implements CategoriaMapper {

    @Override
    public CategoriaDto toCategoriaDto(CategoriaEntity categoria) {
        if ( categoria == null ) {
            return null;
        }

        CategoriaDto categoriaDto = new CategoriaDto();

        categoriaDto.setId( categoria.getId() );
        categoriaDto.setNombre( categoria.getNombre() );
        categoriaDto.setDescripcion( categoria.getDescripcion() );

        return categoriaDto;
    }

    @Override
    public CategoriaEntity toCategoriaEntity(CategoriaDto categoria) {
        if ( categoria == null ) {
            return null;
        }

        CategoriaEntity categoriaEntity = new CategoriaEntity();

        categoriaEntity.setId( categoria.getId() );
        categoriaEntity.setNombre( categoria.getNombre() );
        categoriaEntity.setDescripcion( categoria.getDescripcion() );

        return categoriaEntity;
    }
}
