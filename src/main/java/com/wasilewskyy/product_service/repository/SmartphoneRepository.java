package com.wasilewskyy.product_service.repository;

import com.wasilewskyy.product_service.model.entity.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SmartphoneRepository extends JpaRepository<Smartphone, Long> {

    Optional<Smartphone> findByIdWithConfigurations(@Param("id") Long id);
}
