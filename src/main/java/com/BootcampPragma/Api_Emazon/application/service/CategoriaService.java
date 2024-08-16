package com.BootcampPragma.Api_Emazon.application.service;

import com.BootcampPragma.Api_Emazon.application.dto.CategoriaDto;
import com.BootcampPragma.Api_Emazon.application.mapper.CategoriaRequest;


import com.BootcampPragma.Api_Emazon.domain.api.CategoriaServicePort;
import com.BootcampPragma.Api_Emazon.domain.model.Categoria;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoriaService {

    //private final CategoriaRepository categoriaRepository;
    private final CategoriaRequest categoriaRequest;
    private  final CategoriaServicePort categoriaServicePort;

    public List<CategoriaDto> obtenerCategorias() {
        return categoriaServicePort
                .getAllCategorias()
                .stream()
                .map(categoriaRequest::toCategoriaDto)
                .collect(Collectors.toList()
                );
    }

    public void crearCategoria(CategoriaDto categoriaDto){
        Categoria categoria = categoriaRequest.toCategoria(categoriaDto);
        categoriaServicePort.guardarCategoria(categoria);
    }

}
