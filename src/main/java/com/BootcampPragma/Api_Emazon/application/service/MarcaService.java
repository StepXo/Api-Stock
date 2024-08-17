package com.BootcampPragma.Api_Emazon.application.service;

import com.BootcampPragma.Api_Emazon.application.dto.MarcaDto;
import com.BootcampPragma.Api_Emazon.application.mapper.MarcaRequest;
import com.BootcampPragma.Api_Emazon.domain.api.MarcaServicePort;
import com.BootcampPragma.Api_Emazon.domain.model.Marca;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class MarcaService {

    private final MarcaRequest marcaRequest;
    private  final MarcaServicePort marcaServicePort;

    public List<MarcaDto> obtenerMarcas() {
        return marcaServicePort
                .getAllMarcas()
                .stream()
                .map(marcaRequest::toMarcaDto)
                .collect(Collectors.toList()
                );
    }

    public void crearMarca(MarcaDto marcaDto){
        Marca marca = marcaRequest.toMarca(marcaDto);
        marcaServicePort.guardarMarca(marca);
    }

}
