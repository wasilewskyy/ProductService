package com.wasilewskyy.product_service.repository;

import com.wasilewskyy.product_service.model.entity.ComputerConfiguration;
import com.wasilewskyy.product_service.model.entity.ConfigurationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComputerConfigurationRepository extends JpaRepository<ComputerConfiguration, Long> {

    List<ComputerConfiguration> findByComputerIdAndAvailableTrue(Long computerId);

    List<ComputerConfiguration> findByComputerIdAndTypeAndAvailableTrue(Long computerId, ConfigurationType type);
}
