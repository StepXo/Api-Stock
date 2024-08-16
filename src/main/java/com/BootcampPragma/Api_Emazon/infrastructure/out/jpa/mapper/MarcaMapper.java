package com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.mapper;

import com.BootcampPragma.Api_Emazon.application.dto.MarcaDto;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.entity.MarcaEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface MarcaMapper {
    MarcaDto toMarcaDto(MarcaEntity marca);
    MarcaEntity toMarcaEntity(MarcaDto marca);
}
