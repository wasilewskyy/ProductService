package com.wasilewskyy.product_service.controller;

import com.wasilewskyy.product_service.model.dto.ProductConfigurationGroupDto;
import com.wasilewskyy.product_service.model.dto.ProductDto;
import com.wasilewskyy.product_service.model.request.AddConfigurationRequest;
import com.wasilewskyy.product_service.service.ConfigurationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products/{productId}/configurations")
@RequiredArgsConstructor
public class ConfigurationController {

    private final ConfigurationService configurationService;

    @Operation(summary = "Get all available configurations of product", description = "Returns a list of all configurations of product.")
    @ApiResponse(responseCode = "200", description = "List of available configurations of product",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ProductConfigurationGroupDto.class)))
    @GetMapping
    public List<ProductConfigurationGroupDto> getConfigurations(@PathVariable Long productId) {
        return configurationService.getConfigurations(productId);
    }

    @Operation(summary = "Add configuration to a product", description = "Adds a configuration for product.")
    @ApiResponse(responseCode = "201", description = "Configuration added",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDto.class)))
    @PostMapping
    public ProductDto addConfiguration(@PathVariable Long productId,
                                       @RequestBody AddConfigurationRequest request) {
        return configurationService.addConfiguration(productId, request);
    }
}
