package com.BootcampPragma.Api_Stock.infrastructure.out.jpa.repository;

import com.BootcampPragma.Api_Stock.infrastructure.out.jpa.entity.BrandEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository <BrandEntity, Long> {
    Optional<BrandEntity> findByName(String name);
    void deleteByName(String name);

    Page<BrandEntity> findAllByOrderByNameAsc(Pageable pageable);
    Page<BrandEntity> findAllByOrderByNameDesc(Pageable pageable);
}
