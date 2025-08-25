package com.wasilewskyy.product_service.model.dto;

import com.wasilewskyy.product_service.model.entity.ProductType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private ProductType type;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean active;
    private Boolean hasConfigurations;

    private String baseProcessor;
    private String baseRam;
    private String baseStorage;

    private String baseColor;
    private String baseBatteryCapacity;

    private String brand;
    private String model;
    private Integer warrantyMonths;

    private List<ProductConfigurationDto> availableConfigurations;
}
