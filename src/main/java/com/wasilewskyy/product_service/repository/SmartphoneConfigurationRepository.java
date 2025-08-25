package com.wasilewskyy.product_service.repository;

import com.wasilewskyy.product_service.model.entity.ConfigurationType;
import com.wasilewskyy.product_service.model.entity.SmartphoneConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmartphoneConfigurationRepository extends JpaRepository<SmartphoneConfiguration, Long> {

    List<SmartphoneConfiguration> findBySmartphoneIdAndAvailableTrue(Long smartphoneId);

    List<SmartphoneConfiguration> findBySmartphoneIdAndTypeAndAvailableTrue(Long smartphoneId, ConfigurationType type);
}
