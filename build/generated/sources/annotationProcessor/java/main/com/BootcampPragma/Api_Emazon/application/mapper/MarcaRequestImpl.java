package com.BootcampPragma.Api_Emazon.application.mapper;

import com.BootcampPragma.Api_Emazon.application.dto.MarcaDto;
import com.BootcampPragma.Api_Emazon.domain.model.Marca;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-15T23:16:39-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.12 (Amazon.com Inc.)"
)
@Component
public class MarcaRequestImpl implements MarcaRequest {

    @Override
    public Marca toMarca(MarcaDto marca) {
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
    public MarcaDto toMarcaDto(Marca marcaDto) {
        if ( marcaDto == null ) {
            return null;
        }

        MarcaDto marcaDto1 = new MarcaDto();

        marcaDto1.setId( marcaDto.getId() );
        marcaDto1.setNombre( marcaDto.getNombre() );
        marcaDto1.setDescripcion( marcaDto.getDescripcion() );

        return marcaDto1;
    }
}
