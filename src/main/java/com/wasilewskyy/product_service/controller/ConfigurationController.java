package com.wasilewskyy.product_service.controller;

import com.wasilewskyy.product_service.model.dto.ProductConfigurationGroupDto;
import com.wasilewskyy.product_service.model.dto.ProductDto;
import com.wasilewskyy.product_service.model.request.AddConfigurationRequest;
import com.wasilewskyy.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products/{productId}/configurations")
@RequiredArgsConstructor
public class ConfigurationController {

    private final ProductService productService;

    @GetMapping
    public List<ProductConfigurationGroupDto> getConfigurations(@PathVariable Long productId) {
        return productService.getProductConfigurations(productId);
    }

    @PostMapping
    public ProductDto addConfiguration(@PathVariable Long productId,
                                       @RequestBody AddConfigurationRequest request) {
        return productService.addConfiguration(productId, request);
    }
}
