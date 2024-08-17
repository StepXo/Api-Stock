package com.BootcampPragma.Api_Emazon.domain.spi;

import com.BootcampPragma.Api_Emazon.domain.model.Articulo;

import java.util.List;

public interface ArticuloPersistencePort {
    Articulo guardarArticulo(Articulo crticulo);

    List<Articulo> obtenerArticulos();

    void updateArticulo(Articulo crticulo);

    void deleteArticulo(String articuloId);
}
