package com.BootcampPragma.Api_Emazon.domain.usecase;

import com.BootcampPragma.Api_Emazon.domain.api.CategoriaServicePort;
import com.BootcampPragma.Api_Emazon.domain.model.Categoria;
import com.BootcampPragma.Api_Emazon.domain.exeption.DescripcionIsTooLongException;
import com.BootcampPragma.Api_Emazon.domain.exeption.NameIsTooLongException;
import com.BootcampPragma.Api_Emazon.domain.spi.CategoriaPersistencePort;

import java.util.List;

public class CategoriaHU implements CategoriaServicePort {

    private final CategoriaPersistencePort categoriaPersistencePort;

    public CategoriaHU(CategoriaPersistencePort categoriaPersistencePort) {
        this.categoriaPersistencePort = categoriaPersistencePort;
    }

    @Override
    public Categoria guardarCategoria(Categoria categoria) {

        if (categoria.getNombre().length() > 50) {
            throw new NameIsTooLongException();
        } else if (categoria.getDescripcion().length() > 90) {
            throw new DescripcionIsTooLongException();
        }
        return categoriaPersistencePort.guardarCategoria(categoria);
    }

    @Override
    public List<Categoria> obtenerCategorias() {
        return categoriaPersistencePort.obtenerCategorias();
    }

    @Override
    public void updateCategoria(Categoria categoria) {
        if (categoria.getNombre().length() > 50) {
            throw new NameIsTooLongException();
        } else if (categoria.getDescripcion().length() > 90) {
            throw new DescripcionIsTooLongException();
        }
        categoriaPersistencePort.guardarCategoria(categoria);
    }

    @Override
    public void deleteCategoria(String categoriaId) {

    }

}
