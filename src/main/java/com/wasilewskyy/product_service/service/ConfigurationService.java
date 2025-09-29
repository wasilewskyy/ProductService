package com.wasilewskyy.product_service.service;

import com.wasilewskyy.product_service.model.dto.ProductConfigurationGroupDto;
import com.wasilewskyy.product_service.model.dto.ProductDto;
import com.wasilewskyy.product_service.model.request.AddConfigurationRequest;

import java.util.List;

public interface ConfigurationService {

    List<ProductConfigurationGroupDto> getConfigurations(Long productId);

    ProductDto addConfiguration(Long productId, AddConfigurationRequest request);
}