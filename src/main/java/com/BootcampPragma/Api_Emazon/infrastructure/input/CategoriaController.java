package com.BootcampPragma.Api_Emazon.infrastructure.input;

import com.BootcampPragma.Api_Emazon.application.dto.CategoriaDto;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.entity.CategoriaEntity;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.mapper.CategoriaMapper;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categoria")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    @GetMapping
    private List<CategoriaDto> obtenerCategoria(){
        return categoriaRepository
                .findAll()
                .stream()
                .map(categoriaMapper::categoriaDtoToCategoriaEntity)
                .collect(Collectors.toList()
                );
    }

    @PostMapping
    private CategoriaDto crearCategoria(@RequestBody CategoriaDto categoria){
        CategoriaEntity categoriaEntity = this.categoriaRepository.save(
                categoriaMapper.categoriaEntityToCategoriaDto(categoria)
        );
        return categoriaMapper.categoriaDtoToCategoriaEntity(categoriaEntity);
    }

}
