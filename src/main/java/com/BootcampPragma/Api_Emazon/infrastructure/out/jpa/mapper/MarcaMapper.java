package com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.mapper;

import com.BootcampPragma.Api_Emazon.domain.model.Marca;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.entity.MarcaEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface MarcaMapper {
    Marca toMarca(MarcaEntity marca);
    MarcaEntity toMarcaEntity(Marca marca);
}
