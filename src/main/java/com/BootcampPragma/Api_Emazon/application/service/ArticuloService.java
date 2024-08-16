package com.BootcampPragma.Api_Emazon.application.service;

import com.BootcampPragma.Api_Emazon.application.dto.ArticuloDto;
import com.BootcampPragma.Api_Emazon.application.mapper.ArticuloRequest;
import com.BootcampPragma.Api_Emazon.domain.api.ArticuloServicePort;
import com.BootcampPragma.Api_Emazon.domain.model.Articulo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ArticuloService {

    //private final ArticuloRepository articuloRepository;
    private final ArticuloRequest articuloRequest;
    private  final ArticuloServicePort articuloServicePort;

    public List<ArticuloDto> obtenerArticulos() {
        return articuloServicePort
                .getAllArticulos()
                .stream()
                .map(articuloRequest::toArticuloDto)
                .collect(Collectors.toList()
                );
    }

    public void crearArticulo(ArticuloDto articuloDto){
        Articulo articulo = articuloRequest.toArticulo(articuloDto);
        articuloServicePort.guardarArticulo(articulo);
    }

}
