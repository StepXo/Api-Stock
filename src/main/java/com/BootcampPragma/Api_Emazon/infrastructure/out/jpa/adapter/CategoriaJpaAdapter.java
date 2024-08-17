package com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.adapter;

import com.BootcampPragma.Api_Emazon.domain.model.Categoria;
import com.BootcampPragma.Api_Emazon.domain.spi.CategoriaPersistencePort;
import com.BootcampPragma.Api_Emazon.infrastructure.exeption.CategoriaAlreadyExistsException;
import com.BootcampPragma.Api_Emazon.infrastructure.exeption.DescripcionNotFoundException;
import com.BootcampPragma.Api_Emazon.infrastructure.exeption.NoDataFoundException;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.entity.CategoriaEntity;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.mapper.CategoriaMapper;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
public class CategoriaJpaAdapter implements CategoriaPersistencePort {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    @Override
    public List<Categoria> obtenerCategorias() {

        List<CategoriaEntity> categoriaEntityList = categoriaRepository.findAll();
        if (categoriaEntityList.isEmpty()){throw new NoDataFoundException();}

        return categoriaRepository
                .findAll()
                .stream()
                .map(categoriaMapper::toCategoria)
                .collect(Collectors.toList()
                );
    }

    @Override
    public Categoria guardarCategoria(Categoria categoria){

        if (categoriaRepository.findByNombre(categoria.getNombre()).isPresent()){
            throw new CategoriaAlreadyExistsException();
        } else if (categoria.getDescripcion().isEmpty()){
            throw new DescripcionNotFoundException();
        }

        CategoriaEntity categoriaEntity = this.categoriaRepository.save(
                categoriaMapper.toCategoriaEntity(categoria)
        );
        return categoriaMapper.toCategoria(categoriaEntity);
    }

    @Override
    public void updateCategoria(Categoria categoria){
        if (categoriaRepository.findByNombre(categoria.getNombre()).isPresent()){
            throw new CategoriaAlreadyExistsException();
        } else if (categoria.getDescripcion().isEmpty()){
            throw new DescripcionNotFoundException();
        }
        CategoriaEntity categoriaEntity = this.categoriaRepository.save(
                categoriaMapper.toCategoriaEntity(categoria));
    };

    @Override
    public void deleteCategoria(String categoriaId){categoriaRepository.deleteByNombre(categoriaId);};

}
