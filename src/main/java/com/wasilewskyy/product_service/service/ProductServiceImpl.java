package com.wasilewskyy.product_service.service;

import com.wasilewskyy.product_service.exception.ProductAlreadyExistsException;
import com.wasilewskyy.product_service.exception.ProductNotFoundException;
import com.wasilewskyy.product_service.mapper.ProductMapper;
import com.wasilewskyy.product_service.model.dto.ProductConfigurationGroupDto;
import com.wasilewskyy.product_service.model.dto.ProductDto;
import com.wasilewskyy.product_service.model.entity.Product;
import com.wasilewskyy.product_service.model.entity.ProductType;
import com.wasilewskyy.product_service.model.request.AddConfigurationRequest;
import com.wasilewskyy.product_service.model.request.CreateProductRequest;
import com.wasilewskyy.product_service.model.request.UpdateProductRequest;
import com.wasilewskyy.product_service.repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.engine.config.spi.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public abstract class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final Map<String, ConfigurationService> configurationServices;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository,
                              ProductMapper productMapper,
                              List<ConfigurationService> services) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.configurationServices = services.stream()
                .collect(Collectors.toMap(ConfigurationService::getSupportedType, s -> s));
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.findByActiveTrue()
                .stream().map(productMapper::toDto).toList();
    }

    @Override
    public List<ProductDto> getProductsByType(ProductType type) {
        return productRepository.findByTypeAndActiveTrue(type)
                .stream().map(productMapper::toDto).toList();
    }

    @Override
    public ProductDto getProductById(Long id) {
        return productMapper.toDto(findProduct(id));
    }

    @Override
    public List<ProductConfigurationGroupDto> getProductConfigurations(Long productId) {
        Product product = findProduct(productId);
        return configurationServices.get(product.getType().name())
                .getConfigurations(productId);
    }

    @Override
    public ProductDto createProduct(CreateProductRequest request) {
        if (productRepository.existsByNameAndActiveTrue(request.getName())) {
            throw new ProductAlreadyExistsException("Product with name '" + request.getName() + "' already exists");
        }
        Product saved = productRepository.save(productMapper.toEntity(request));
        return productMapper.toDto(saved);
    }

    @Override
    public ProductDto updateProduct(Long id, UpdateProductRequest request) {
        Product product = findProduct(id);
        productMapper.updateEntity(product, request);
        return productMapper.toDto(productRepository.save(product));
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = findProduct(id);
        product.setActive(false);
        productRepository.save(product);
    }

    @Override
    public ProductDto addConfiguration(Long productId, AddConfigurationRequest request) {
        Product product = findProduct(productId);
        configurationServices.get(product.getType().name()).addConfiguration(product, request);
        return productMapper.toDto(productRepository.save(product));
    }

    private Product findProduct(Long id) {
        return productRepository.findByIdAndActiveTrue(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
    }
}