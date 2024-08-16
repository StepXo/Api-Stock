package com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.adapter;

import com.BootcampPragma.Api_Emazon.application.dto.MarcaDto;
import com.BootcampPragma.Api_Emazon.infrastructure.exeption.MarcaAlreadyExistsException;
import com.BootcampPragma.Api_Emazon.infrastructure.exeption.DescripcionNotFoundException;
import com.BootcampPragma.Api_Emazon.infrastructure.exeption.NoDataFoundException;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.entity.MarcaEntity;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.entity.MarcaEntity;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.mapper.MarcaMapper;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.repository.MarcaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MarcaJpaAdapter {

    private final MarcaRepository marcaRepository;
    private final MarcaMapper marcaMapper;

    public List<MarcaDto> obtenerMarcas() {
        List<MarcaEntity> marcaEntityList = marcaRepository.findAll();
        if (marcaEntityList.isEmpty()){throw new NoDataFoundException();}
        return marcaRepository
                .findAll()
                .stream()
                .map(marcaMapper::toMarcaDto)
                .collect(Collectors.toList()
                );
    }

    public MarcaDto crearMarca(@RequestBody MarcaDto marca){
        
        if (marcaRepository.findByName(marca.getNombre()).isPresent()){
            throw new MarcaAlreadyExistsException();
        } else if (marca.getDescripcion().isEmpty()){
            throw new DescripcionNotFoundException();
        }
        
        MarcaEntity marcaEntity = this.marcaRepository.save(
                marcaMapper.toMarcaEntity(marca)
        );
        return marcaMapper.toMarcaDto(marcaEntity);
    }

}
