package com.BootcampPragma.Api_Emazon.domain.api;

import com.BootcampPragma.Api_Emazon.domain.model.Categoria;

import java.util.List;

public interface CategoriaServicePort {

        Categoria guardarCategoria(Categoria categoria);

        List<Categoria> obtenerCategorias();

        void updateCategoria(Categoria categoria);

        void deleteCategoria(String categoriaId);
}
