package com.wasilewskyy.product_service.service;

import com.wasilewskyy.product_service.exception.ProductNotFoundException;
import com.wasilewskyy.product_service.mapper.ProductMapper;
import com.wasilewskyy.product_service.model.dto.ConfigurationOptionDto;
import com.wasilewskyy.product_service.model.dto.ProductConfigurationGroupDto;
import com.wasilewskyy.product_service.model.dto.ProductDto;
import com.wasilewskyy.product_service.model.entity.Product;
import com.wasilewskyy.product_service.model.entity.ProductConfiguration;
import com.wasilewskyy.product_service.model.request.AddConfigurationRequest;
import com.wasilewskyy.product_service.repository.ProductConfigurationRepository;
import com.wasilewskyy.product_service.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ConfigurationServiceImpl implements ConfigurationService {

    private final ProductRepository productRepository;
    private final ProductConfigurationRepository configurationRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductConfigurationGroupDto> getConfigurations(Long productId) {
        Product product = findProduct(productId);
        List<ProductConfiguration> configs =
                configurationRepository.findByProductIdAndAvailableTrue(product.getId());

        return configs.stream()
                .collect(Collectors.groupingBy(ProductConfiguration::getType))
                .entrySet().stream()
                .map(entry -> new ProductConfigurationGroupDto(
                        entry.getKey(),
                        entry.getKey().name(),
                        entry.getValue().stream()
                                .map(cfg -> new ConfigurationOptionDto(
                                        cfg.getId(),
                                        cfg.getName(),
                                        cfg.getValue(),
                                        cfg.getDisplayName(),
                                        cfg.getAdditionalPrice(),
                                        cfg.getAvailable()
                                ))
                                .toList()
                ))
                .toList();
    }

    @Override
    public ProductDto addConfiguration(Long productId, AddConfigurationRequest request) {
        Product product = findProduct(productId);

        ProductConfiguration config = new ProductConfiguration();
        config.setProduct(product);
        config.setType(request.getType());
        config.setName(request.getName());
        config.setValue(request.getValue());
        config.setDisplayName(request.getDisplayName());
        config.setAdditionalPrice(request.getAdditionalPrice());
        config.setAvailable(true);

        configurationRepository.save(config);
        product.getConfigurations().add(config);

        return productMapper.toDto(productRepository.save(product));
    }

    private Product findProduct(Long id) {
        return productRepository.findByIdAndActiveTrue(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
    }
}