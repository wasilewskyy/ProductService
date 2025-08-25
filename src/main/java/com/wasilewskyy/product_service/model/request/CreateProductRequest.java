package com.wasilewskyy.product_service.model.request;

import com.wasilewskyy.product_service.model.entity.ProductType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateProductRequest {

    private String name;
    private BigDecimal price;
    private String description;
    private ProductType type;

    private String baseProcessor;
    private String baseRam;
    private String baseStorage;

    private String baseColor;
    private String baseBatteryCapacity;

    private String brand;
    private String model;
    private Integer warrantyMonths;
}

