package com.wasilewskyy.product_service.service;

import com.wasilewskyy.product_service.model.entity.Product;
import com.wasilewskyy.product_service.model.entity.ProductType;
import com.wasilewskyy.product_service.model.dto.ProductConfigurationGroupDto;
import com.wasilewskyy.product_service.model.request.AddConfigurationRequest;

import java.util.List;

public interface ConfigurationService {

    ProductType getSupportedType();
    List<ProductConfigurationGroupDto> getConfigurations(Long productId);
    void addConfiguration(Product product, AddConfigurationRequest request);
}