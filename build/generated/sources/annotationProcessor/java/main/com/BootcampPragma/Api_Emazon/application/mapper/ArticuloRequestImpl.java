package com.BootcampPragma.Api_Emazon.application.mapper;

import com.BootcampPragma.Api_Emazon.application.dto.ArticuloDto;
import com.BootcampPragma.Api_Emazon.domain.model.Articulo;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-17T00:16:10-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.12 (Amazon.com Inc.)"
)
@Component
public class ArticuloRequestImpl implements ArticuloRequest {

    @Override
    public Articulo toArticulo(ArticuloDto categoria) {
        if ( categoria == null ) {
            return null;
        }

        Long cantidad = null;
        double precio = 0.0d;
        long id = 0L;
        String nombre = null;
        String descripcion = null;

        cantidad = categoria.getCantidad();
        precio = categoria.getPrecio();
        id = categoria.getId();
        nombre = categoria.getNombre();
        descripcion = categoria.getDescripcion();

        Articulo articulo = new Articulo( id, nombre, descripcion, cantidad, precio );

        return articulo;
    }

    @Override
    public ArticuloDto toArticuloDto(Articulo categoriaDto) {
        if ( categoriaDto == null ) {
            return null;
        }

        ArticuloDto articuloDto = new ArticuloDto();

        articuloDto.setId( categoriaDto.getId() );
        articuloDto.setNombre( categoriaDto.getNombre() );
        articuloDto.setDescripcion( categoriaDto.getDescripcion() );
        if ( categoriaDto.getCantidad() != null ) {
            articuloDto.setCantidad( categoriaDto.getCantidad() );
        }
        articuloDto.setPrecio( categoriaDto.getPrecio() );

        return articuloDto;
    }
}
