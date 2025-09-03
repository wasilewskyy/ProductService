package com.wasilewskyy.product_service.repository;

import com.wasilewskyy.product_service.model.entity.ConfigurationType;
import com.wasilewskyy.product_service.model.entity.ProductConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductConfigurationRepository extends JpaRepository<ProductConfiguration, Long> {

    List<ProductConfiguration> findByProductIdAndAvailableTrue(Long productId);

    List<ProductConfiguration> findByProductIdAndTypeAndAvailableTrue(Long productId, ConfigurationType type);
}

