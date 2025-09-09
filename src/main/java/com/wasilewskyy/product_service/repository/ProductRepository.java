package com.wasilewskyy.product_service.repository;

import com.wasilewskyy.product_service.model.entity.Product;
import com.wasilewskyy.product_service.model.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByTypeAndActiveTrue(ProductType type);

    List<Product> findByActiveTrue();

    Optional<Product> findByIdAndActiveTrue(Long id);

    boolean existsByNameAndActiveTrue(String name);

}