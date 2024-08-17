package com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.mapper;

import com.BootcampPragma.Api_Emazon.domain.model.Articulo;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.entity.ArticuloEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-17T00:16:09-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.12 (Amazon.com Inc.)"
)
@Component
public class ArticuloMapperImpl implements ArticuloMapper {

    @Override
    public Articulo toArticulo(ArticuloEntity articulo) {
        if ( articulo == null ) {
            return null;
        }

        Long cantidad = null;
        double precio = 0.0d;
        long id = 0L;
        String nombre = null;
        String descripcion = null;

        cantidad = articulo.getCantidad();
        precio = articulo.getPrecio();
        id = articulo.getId();
        nombre = articulo.getNombre();
        descripcion = articulo.getDescripcion();

        Articulo articulo1 = new Articulo( id, nombre, descripcion, cantidad, precio );

        return articulo1;
    }

    @Override
    public ArticuloEntity toArticuloEntity(Articulo articulo) {
        if ( articulo == null ) {
            return null;
        }

        ArticuloEntity articuloEntity = new ArticuloEntity();

        articuloEntity.setId( articulo.getId() );
        articuloEntity.setNombre( articulo.getNombre() );
        articuloEntity.setDescripcion( articulo.getDescripcion() );
        if ( articulo.getCantidad() != null ) {
            articuloEntity.setCantidad( articulo.getCantidad() );
        }
        articuloEntity.setPrecio( articulo.getPrecio() );

        return articuloEntity;
    }
}
