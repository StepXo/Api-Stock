package com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.mapper;

import com.BootcampPragma.Api_Emazon.application.dto.MarcaDto;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.entity.MarcaEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-15T23:16:39-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 17.0.12 (Amazon.com Inc.)"
)
@Component
public class MarcaMapperImpl implements MarcaMapper {

    @Override
    public MarcaDto toMarcaDto(MarcaEntity marca) {
        if ( marca == null ) {
            return null;
        }

        MarcaDto marcaDto = new MarcaDto();

        marcaDto.setId( marca.getId() );
        marcaDto.setNombre( marca.getNombre() );
        marcaDto.setDescripcion( marca.getDescripcion() );

        return marcaDto;
    }

    @Override
    public MarcaEntity toMarcaEntity(MarcaDto marca) {
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
