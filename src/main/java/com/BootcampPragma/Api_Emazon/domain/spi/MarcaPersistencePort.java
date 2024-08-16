package com.BootcampPragma.Api_Emazon.domain.spi;

import com.BootcampPragma.Api_Emazon.domain.model.Marca;

import java.util.List;

public interface MarcaPersistencePort {
    Marca guardarMarca(Marca marca);

    List<Marca> getAllMarcas();

    void updateMarca(Marca marca);

    void deleteMarca(Marca marca);
}
