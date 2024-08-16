package com.BootcampPragma.Api_Emazon.application.mapper;

import com.BootcampPragma.Api_Emazon.application.dto.MarcaDto;
import com.BootcampPragma.Api_Emazon.domain.model.Marca;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface MarcaRequest {

    Marca toMarca(MarcaDto marca);
    MarcaDto toMarcaDto(Marca marcaDto);

}
