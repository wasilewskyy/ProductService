package com.wasilewskyy.product_service.service;

import com.wasilewskyy.product_service.exception.ProductAlreadyExistsException;
import com.wasilewskyy.product_service.exception.ProductNotFoundException;
import com.wasilewskyy.product_service.mapper.ProductMapper;
import com.wasilewskyy.product_service.model.dto.ProductDto;
import com.wasilewskyy.product_service.model.entity.Product;
import com.wasilewskyy.product_service.model.entity.ProductType;
import com.wasilewskyy.product_service.model.request.CreateProductRequest;
import com.wasilewskyy.product_service.model.request.UpdateProductRequest;
import com.wasilewskyy.product_service.repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.findByActiveTrue()
                .stream()
                .map(productMapper::toDto)
                .toList();
    }

    @Override
    public List<ProductDto> getProductsByType(ProductType type) {
        return productRepository.findByTypeAndActiveTrue(type)
                .stream()
                .map(productMapper::toDto)
                .toList();
    }

    @Override
    public ProductDto getProductById(Long id) {
        return productMapper.toDto(findProduct(id));
    }

    @Override
    public ProductDto createProduct(CreateProductRequest request) {
        if (productRepository.existsByNameAndActiveTrue(request.getName())) {
            throw new ProductAlreadyExistsException(
                    "Product with name '" + request.getName() + "' already exists");
        }
        Product product = productMapper.toEntity(request);
        Product saved = productRepository.save(product);
        return productMapper.toDto(saved);
    }

    @Override
    public ProductDto updateProduct(Long id, UpdateProductRequest request) {
        Product product = findProduct(id);
        productMapper.updateEntity(product, request);
        Product updated = productRepository.save(product);
        return productMapper.toDto(updated);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = findProduct(id);
        product.setActive(false);
        productRepository.save(product);
    }

    private Product findProduct(Long id) {
        return productRepository.findByIdAndActiveTrue(id)
                .orElseThrow(() -> new ProductNotFoundException(
                        "Product not found with id: " + id));
    }
}