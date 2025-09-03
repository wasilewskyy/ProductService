package com.wasilewskyy.product_service.model.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdateProductRequest {
    private String name;
    private BigDecimal price;
    private String description;
}