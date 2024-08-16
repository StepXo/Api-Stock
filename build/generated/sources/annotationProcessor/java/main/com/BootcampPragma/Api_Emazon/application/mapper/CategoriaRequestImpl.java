package com.BootcampPragma.Api_Emazon.application.mapper;

import com.BootcampPragma.Api_Emazon.application.dto.CategoriaDto;
import com.BootcampPragma.Api_Emazon.domain.model.Categoria;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-15T23:16:39-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.12 (Amazon.com Inc.)"
)
@Component
public class CategoriaRequestImpl implements CategoriaRequest {

    @Override
    public Categoria toCategoria(CategoriaDto categoria) {
        if ( categoria == null ) {
            return null;
        }

        long id = 0L;
        String nombre = null;
        String descripcion = null;

        id = categoria.getId();
        nombre = categoria.getNombre();
        descripcion = categoria.getDescripcion();

        Categoria categoria1 = new Categoria( id, nombre, descripcion );

        return categoria1;
    }

    @Override
    public CategoriaDto toCategoriaDto(Categoria categoriaDto) {
        if ( categoriaDto == null ) {
            return null;
        }

        CategoriaDto categoriaDto1 = new CategoriaDto();

        categoriaDto1.setId( categoriaDto.getId() );
        categoriaDto1.setNombre( categoriaDto.getNombre() );
        categoriaDto1.setDescripcion( categoriaDto.getDescripcion() );

        return categoriaDto1;
    }
}
