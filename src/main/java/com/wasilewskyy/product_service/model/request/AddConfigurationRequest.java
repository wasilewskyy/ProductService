package com.wasilewskyy.product_service.model.request;

import com.wasilewskyy.product_service.model.entity.ConfigurationType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AddConfigurationRequest {

    private ConfigurationType type;
    private String name;
    private String value;
    private String displayName;
    private BigDecimal additionalPrice;
}
