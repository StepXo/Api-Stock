package com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.repository;

import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.entity.ArticuloEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ArticuloRepository extends JpaRepository <ArticuloEntity, Long> {
    void deleteByNombre(String Nombre);


}
