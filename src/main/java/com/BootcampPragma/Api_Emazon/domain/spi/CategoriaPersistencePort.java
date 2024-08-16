package com.BootcampPragma.Api_Emazon.domain.spi;

import com.BootcampPragma.Api_Emazon.domain.model.Categoria;

import java.util.List;

public interface CategoriaPersistencePort {
    Categoria guardarCategoria(Categoria categoria);

    List<Categoria> getAllCategorias();

    void updateCategoria(Categoria categoria);

    void deleteCategoria(Categoria categoria);
}
