package com.wasilewskyy.product_service.model.dto;

import com.wasilewskyy.product_service.model.entity.ConfigurationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductConfigurationDto {

    private Long id;
    private ConfigurationType type;
    private String name;
    private String value;
    private String displayName;
    private BigDecimal additionalPrice;
    private Boolean available;
}
