package com.wasilewskyy.product_service.repository;

import com.wasilewskyy.product_service.model.entity.Electronics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectronicsRepository extends JpaRepository<Electronics, Long> {
}
