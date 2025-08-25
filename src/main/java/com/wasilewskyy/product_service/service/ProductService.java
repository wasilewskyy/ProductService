package com.wasilewskyy.product_service.service;

import com.wasilewskyy.product_service.model.entity.ProductType;
import com.wasilewskyy.product_service.model.dto.ProductConfigurationGroupDto;
import com.wasilewskyy.product_service.model.dto.ProductDto;
import com.wasilewskyy.product_service.model.request.AddConfigurationRequest;
import com.wasilewskyy.product_service.model.request.CreateProductRequest;
import com.wasilewskyy.product_service.model.request.UpdateProductRequest;

import java.util.List;

public interface ProductService {

    List<ProductDto> getAllProducts();

    List<ProductDto> getProductsByType(ProductType type);

    ProductDto getProductById(Long id);

    List<ProductConfigurationGroupDto> getProductConfigurations(Long productId);

    ProductDto createProduct(CreateProductRequest request);

    ProductDto updateProduct(Long id, UpdateProductRequest request);

    void deleteProduct(Long id);

    ProductDto addConfiguration(Long productId, AddConfigurationRequest request);
}