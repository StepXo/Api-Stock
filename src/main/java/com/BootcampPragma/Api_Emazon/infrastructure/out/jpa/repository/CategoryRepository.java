package com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.repository;

import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository <CategoryEntity, Long> {
    Optional<CategoryEntity> findByName(String name);
    Optional<CategoryEntity> findById(Long id);

    void deleteByName(String name);

}
