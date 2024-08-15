package com.BootcampPragma.Api_Emazon.infrastructure.input;


import com.BootcampPragma.Api_Emazon.application.dto.MarcaDto;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.entity.MarcaEntity;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.mapper.MarcaMapper;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.repository.MarcaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/marca")
@RequiredArgsConstructor
public class MarcaController {

    private final MarcaRepository marcaRepository;
    private final MarcaMapper marcaMapper;

    @GetMapping
    private List<MarcaDto> obtenerMarca(){
        return marcaRepository
                .findAll()
                .stream()
                .map(marcaMapper::marcaDtoToMarcaEntity)
                .collect(Collectors.toList()
                );
    }

    @PostMapping
    private MarcaDto crearMarca(@RequestBody MarcaDto marca){
        MarcaEntity marcaEntity = this.marcaRepository.save(
                marcaMapper.marcaEntityToMarcaDto(marca)
        );
        return marcaMapper.marcaDtoToMarcaEntity(marcaEntity);
    }

}
