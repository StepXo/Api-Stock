package com.BootcampPragma.Api_Emazon.domain.usecase;

import com.BootcampPragma.Api_Emazon.domain.api.ArticuloServicePort;
import com.BootcampPragma.Api_Emazon.domain.exeption.DescripcionIsTooLongException;
import com.BootcampPragma.Api_Emazon.domain.exeption.NameIsTooLongException;
import com.BootcampPragma.Api_Emazon.domain.model.Articulo;
import com.BootcampPragma.Api_Emazon.domain.spi.ArticuloPersistencePort;

import java.util.List;

public class ArticuloHU implements ArticuloServicePort {

    private final ArticuloPersistencePort articuloPersistencePort;

    public ArticuloHU(ArticuloPersistencePort articuloPersistencePort) {
        this.articuloPersistencePort = articuloPersistencePort;
    }

    @Override
    public Articulo guardarArticulo(Articulo articulo) {
        return articuloPersistencePort.guardarArticulo(articulo);
    }

    @Override
    public List<Articulo> obtenerArticulos() {
        return articuloPersistencePort.obtenerArticulos();
    }

    @Override
    public void updateArticulo(Articulo articulo) {
        articuloPersistencePort.guardarArticulo(articulo);
    }

    @Override
    public void deleteArticulo(String articuloId) {

    }

}
