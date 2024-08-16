package com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.repository;

import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.entity.ArticuloEntity;
import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository <CategoriaEntity, Long> {
    Optional<CategoriaEntity> findByName (String Nombre);

    void deleteByName(String Nombre);
}
