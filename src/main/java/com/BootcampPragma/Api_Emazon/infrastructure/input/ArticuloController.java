package com.BootcampPragma.Api_Emazon.infrastructure.input;

import com.BootcampPragma.Api_Emazon.application.dto.ArticuloDto;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.entity.ArticuloEntity;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.mapper.ArticuloMapper;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.repository.ArticuloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/articulo")
@RequiredArgsConstructor
public class ArticuloController {

    private final ArticuloRepository articuloRepository;
    private final ArticuloMapper articuloMapper;

    @GetMapping
    private List<ArticuloDto> obtenerArticulo(){
        return articuloRepository
                .findAll()
                .stream()
                .map(articuloMapper::articuloDtoToArticuloEntity)
                .collect(Collectors.toList()
                );
    }

    @PostMapping
    private ArticuloDto crearArticulo(@RequestBody ArticuloDto articulo){
        ArticuloEntity articuloEntity = this.articuloRepository.save(
                articuloMapper.articuloEntityToArticuloDto(articulo)
        );
        return articuloMapper.articuloDtoToArticuloEntity(articuloEntity);
    }

}
