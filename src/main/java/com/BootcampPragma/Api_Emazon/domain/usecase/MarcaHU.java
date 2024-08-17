package com.BootcampPragma.Api_Emazon.domain.usecase;

import com.BootcampPragma.Api_Emazon.domain.api.MarcaServicePort;
import com.BootcampPragma.Api_Emazon.domain.exeption.DescripcionIsTooLongException;
import com.BootcampPragma.Api_Emazon.domain.exeption.NameIsTooLongException;
import com.BootcampPragma.Api_Emazon.domain.model.Marca;
import com.BootcampPragma.Api_Emazon.domain.spi.MarcaPersistencePort;

import java.util.List;

public class MarcaHU implements MarcaServicePort {

    private final MarcaPersistencePort marcaPersistencePort;

    public MarcaHU(MarcaPersistencePort marcaPersistencePort) {
        this.marcaPersistencePort = marcaPersistencePort;
    }

    @Override
    public Marca guardarMarca(Marca marca) {

        if (marca.getNombre().length() > 50) {
            throw new NameIsTooLongException();
        } else if (marca.getDescripcion().length() > 120) {
            throw new DescripcionIsTooLongException();
        }
        return marcaPersistencePort.guardarMarca(marca);
    }

    @Override
    public List<Marca> getAllMarcas() {
        return marcaPersistencePort.obtenerMarcas();
    }

    @Override
    public void updateMarca(Marca marca) {
        if (marca.getNombre().length() > 50) {
            throw new NameIsTooLongException();
        } else if (marca.getDescripcion().length() > 120) {
            throw new DescripcionIsTooLongException();
        }
        marcaPersistencePort.guardarMarca(marca);
    }

    @Override
    public void deleteMarca(String marcaId) {

    }

}
