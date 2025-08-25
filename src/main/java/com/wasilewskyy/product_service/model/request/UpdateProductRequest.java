package com.wasilewskyy.product_service.model.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdateProductRequest {

    private String name;
    private BigDecimal price;
    private String description;

    private String baseProcessor;
    private String baseRam;
    private String baseStorage;

    private String baseColor;
    private String baseBatteryCapacity;

    private String brand;
    private String model;
    private Integer warrantyMonths;
}
