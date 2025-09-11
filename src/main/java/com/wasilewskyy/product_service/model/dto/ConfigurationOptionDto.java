package com.wasilewskyy.product_service.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConfigurationOptionDto {

    private Long id;
    private String name;
    private String value;
    private String displayName;
    private BigDecimal additionalPrice;
    private Boolean available;
}
