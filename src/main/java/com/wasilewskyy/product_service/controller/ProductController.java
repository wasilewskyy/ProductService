package com.wasilewskyy.product_service.controller;

import com.wasilewskyy.product_service.model.entity.ProductType;
import com.wasilewskyy.product_service.model.dto.ProductDto;
import com.wasilewskyy.product_service.model.request.CreateProductRequest;
import com.wasilewskyy.product_service.model.request.UpdateProductRequest;
import com.wasilewskyy.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductDto> getProducts(@RequestParam(required = false) ProductType type) {
        if (type != null) {
            return productService.getProductsByType(type);
        }
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public ProductDto createProduct(@RequestBody CreateProductRequest request) {
        return productService.createProduct(request);
    }

    @PutMapping("/{id}")
    public ProductDto updateProduct(@PathVariable Long id,
                                    @RequestBody UpdateProductRequest request) {
        return productService.updateProduct(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}