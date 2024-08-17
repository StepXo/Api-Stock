package com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.adapter;

import com.BootcampPragma.Api_Emazon.domain.model.Articulo;
import com.BootcampPragma.Api_Emazon.domain.spi.ArticuloPersistencePort;
import com.BootcampPragma.Api_Emazon.infrastructure.exeption.DescripcionNotFoundException;
import com.BootcampPragma.Api_Emazon.infrastructure.exeption.NoDataFoundException;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.entity.ArticuloEntity;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.mapper.ArticuloMapper;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.repository.ArticuloRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
public class ArticuloJpaAdapter implements ArticuloPersistencePort {

    private final ArticuloRepository articuloRepository;
    private final ArticuloMapper articuloMapper;

    @Override
    public List<Articulo> obtenerArticulos() {

        List<ArticuloEntity> articuloEntityList = articuloRepository.findAll();
        if (articuloEntityList.isEmpty()){throw new NoDataFoundException();}

        return articuloRepository
                .findAll()
                .stream()
                .map(articuloMapper::toArticulo)
                .collect(Collectors.toList()
                );
    }

    @Override
    public Articulo guardarArticulo(Articulo articulo){

        if (articulo.getDescripcion().isEmpty()){
            throw new DescripcionNotFoundException();
        }

        ArticuloEntity articuloEntity = this.articuloRepository.save(
                articuloMapper.toArticuloEntity(articulo)
        );
        return articuloMapper.toArticulo(articuloEntity);
    }

    @Override
    public void updateArticulo(Articulo articulo){
        if (articulo.getDescripcion().isEmpty()){
            throw new DescripcionNotFoundException();
        }
        ArticuloEntity articuloEntity = this.articuloRepository.save(
                articuloMapper.toArticuloEntity(articulo));
    };

    @Override
    public void deleteArticulo(String articuloId){articuloRepository.deleteByNombre(articuloId);};

}
