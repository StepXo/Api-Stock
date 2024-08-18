package com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.repository;

import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.entity.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository <CategoryEntity, Long> {
    Optional<CategoryEntity> findByName(String name);
    void deleteByName(String name);

    Page<CategoryEntity> findAllByOrderByNameAsc(Pageable pageable);
    Page<CategoryEntity> findAllByOrderByNameDesc(Pageable pageable);



}
