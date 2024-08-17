package com.BootcampPragma.Api_Emazon.domain.api;

import com.BootcampPragma.Api_Emazon.domain.model.Articulo;

import java.util.List;

public interface ArticuloServicePort {

        Articulo guardarArticulo(Articulo articulo);

        List<Articulo> obtenerArticulos();

        void updateArticulo(Articulo articulo);

        void deleteArticulo(String articuloId);
}
