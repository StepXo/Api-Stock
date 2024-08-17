package com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.mapper;

import com.BootcampPragma.Api_Emazon.domain.model.Marca;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.entity.MarcaEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-17T00:16:10-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.12 (Amazon.com Inc.)"
)
@Component
public class MarcaMapperImpl implements MarcaMapper {

    @Override
    public Marca toMarca(MarcaEntity marca) {
        if ( marca == null ) {
            return null;
        }

        long id = 0L;
        String nombre = null;
        String descripcion = null;

        id = marca.getId();
        nombre = marca.getNombre();
        descripcion = marca.getDescripcion();

        Marca marca1 = new Marca( id, nombre, descripcion );

        return marca1;
    }

    @Override
    public MarcaEntity toMarcaEntity(Marca marca) {
        if ( marca == null ) {
            return null;
        }

        MarcaEntity marcaEntity = new MarcaEntity();

        marcaEntity.setId( marca.getId() );
        marcaEntity.setNombre( marca.getNombre() );
        marcaEntity.setDescripcion( marca.getDescripcion() );

        return marcaEntity;
    }
}
