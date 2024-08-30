package com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.repository;

import com.BootcampPragma.Api_Emazon.infrastructure.out.jpa.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ItemRepository extends JpaRepository <ItemEntity, Long> {
    Optional<ItemEntity> findByName(String name);
    Optional<ItemEntity> findByCategoryId(Long categoryId);
    void deleteByName(String name);
}
