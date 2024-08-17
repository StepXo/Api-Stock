package com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.adapter;

import com.BootcampPragma.Api_Emazon.domain.model.Marca;
import com.BootcampPragma.Api_Emazon.domain.spi.MarcaPersistencePort;
import com.BootcampPragma.Api_Emazon.infrastructure.exeption.MarcaAlreadyExistsException;
import com.BootcampPragma.Api_Emazon.infrastructure.exeption.DescripcionNotFoundException;
import com.BootcampPragma.Api_Emazon.infrastructure.exeption.NoDataFoundException;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.entity.MarcaEntity;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.mapper.MarcaMapper;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.repository.MarcaRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
public class MarcaJpaAdapter implements MarcaPersistencePort {

    private final MarcaRepository marcaRepository;
    private final MarcaMapper marcaMapper;

    @Override
    public List<Marca> obtenerMarcas() {

        List<MarcaEntity> marcaEntityList = marcaRepository.findAll();
        if (marcaEntityList.isEmpty()){throw new NoDataFoundException();}

        return marcaRepository
                .findAll()
                .stream()
                .map(marcaMapper::toMarca)
                .collect(Collectors.toList()
                );
    }

    @Override
    public Marca guardarMarca(Marca marca){

        if (marcaRepository.findByNombre(marca.getNombre()).isPresent()){
            throw new MarcaAlreadyExistsException();
        } else if (marca.getDescripcion().isEmpty()){
            throw new DescripcionNotFoundException();
        }

        MarcaEntity marcaEntity = this.marcaRepository.save(
                marcaMapper.toMarcaEntity(marca)
        );
        return marcaMapper.toMarca(marcaEntity);
    }

    @Override
    public void updateMarca(Marca marca){
        if (marcaRepository.findByNombre(marca.getNombre()).isPresent()){
            throw new MarcaAlreadyExistsException();
        } else if (marca.getDescripcion().isEmpty()){
            throw new DescripcionNotFoundException();
        }
        MarcaEntity marcaEntity = this.marcaRepository.save(
                marcaMapper.toMarcaEntity(marca));
    };

    @Override
    public void deleteMarca(String marcaId){marcaRepository.deleteByNombre(marcaId);};

}
