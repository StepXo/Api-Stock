package com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.adapter;

import com.BootcampPragma.Api_Emazon.application.dto.ArticuloDto;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.entity.ArticuloEntity;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.mapper.ArticuloMapper;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.repository.ArticuloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticuloJpaAdapter {

    private final ArticuloRepository articuloRepository;
    private final ArticuloMapper articuloMapper;

    public List<ArticuloDto> obtenerArticulos() {
        return articuloRepository
                .findAll()
                .stream()
                .map(articuloMapper::toArticuloDto)
                .collect(Collectors.toList()
                );
    }

    public ArticuloDto crearArticulo(@RequestBody ArticuloDto articulo){
        ArticuloEntity articuloEntity = this.articuloRepository.save(
                articuloMapper.toArticuloEntity(articulo)
        );
        return articuloMapper.toArticuloDto(articuloEntity);
    }

}
