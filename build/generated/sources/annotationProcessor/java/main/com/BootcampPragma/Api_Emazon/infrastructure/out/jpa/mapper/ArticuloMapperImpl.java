package com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.mapper;

import com.BootcampPragma.Api_Emazon.application.dto.ArticuloDto;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.entity.ArticuloEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-15T23:32:26-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.12 (Amazon.com Inc.)"
)
@Component
public class ArticuloMapperImpl implements ArticuloMapper {

    @Override
    public ArticuloDto toArticuloDto(ArticuloEntity articulo) {
        if ( articulo == null ) {
            return null;
        }

        ArticuloDto articuloDto = new ArticuloDto();

        articuloDto.setId( articulo.getId() );
        articuloDto.setNombre( articulo.getNombre() );
        articuloDto.setDescripcion( articulo.getDescripcion() );
        articuloDto.setCantidad( articulo.getCantidad() );
        articuloDto.setPrecio( articulo.getPrecio() );

        return articuloDto;
    }

    @Override
    public ArticuloEntity toArticuloEntity(ArticuloDto articulo) {
        if ( articulo == null ) {
            return null;
        }

        ArticuloEntity articuloEntity = new ArticuloEntity();

        articuloEntity.setId( articulo.getId() );
        articuloEntity.setNombre( articulo.getNombre() );
        articuloEntity.setDescripcion( articulo.getDescripcion() );
        articuloEntity.setCantidad( articulo.getCantidad() );
        articuloEntity.setPrecio( articulo.getPrecio() );

        return articuloEntity;
    }
}
