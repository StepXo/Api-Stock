package com.BootcampPragma.Api_Emazon.domain.api;

import com.BootcampPragma.Api_Emazon.domain.model.Marca;

import java.util.List;

public interface MarcaServicePort {

        Marca guardarMarca(Marca marca);

        List<Marca> getAllMarcas();

        void updateMarca(Marca marca);

        void deleteMarca(String marcaId);
}
