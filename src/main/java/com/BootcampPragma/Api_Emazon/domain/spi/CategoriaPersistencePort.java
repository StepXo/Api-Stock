package com.BootcampPragma.Api_Emazon.domain.spi;

import com.BootcampPragma.Api_Emazon.domain.model.Categoria;

import java.util.List;

public interface CategoriaPersistencePort {
    Categoria guardarCategoria(Categoria categoria);

    void updateCategoria(Categoria categoria);

    List<Categoria> obtenerCategorias();

    void deleteCategoria(String categoriaId);
}
