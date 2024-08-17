package com.BootcampPragma.Api_Emazon.domain.spi;

import com.BootcampPragma.Api_Emazon.domain.model.Marca;

import java.util.List;

public interface MarcaPersistencePort {
    Marca guardarMarca(Marca marca);

    List<Marca> obtenerMarcas();

    void updateMarca(Marca marca);

    void deleteMarca(String marcaId);
}
