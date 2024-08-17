package com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.mapper;

import com.BootcampPragma.Api_Emazon.domain.model.Categoria;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.entity.CategoriaEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-17T00:16:10-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.12 (Amazon.com Inc.)"
)
public class CategoriaMapperImpl implements CategoriaMapper {

    @Override
    public Categoria toCategoria(CategoriaEntity categoria) {
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
    public CategoriaEntity toCategoriaEntity(Categoria categoria) {
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
