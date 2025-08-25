package com.wasilewskyy.product_service.repository;

import com.wasilewskyy.product_service.model.entity.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ComputerRepository extends JpaRepository<Computer, Long> {

    Optional<Computer> findByIdWithConfigurations(@Param("id") Long id);
}
