package com.wasilewskyy.product_service.model.dto;

import com.wasilewskyy.product_service.model.entity.ConfigurationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductConfigurationGroupDto {

    private ConfigurationType type;
    private String displayName;
    private List<ConfigurationOptionDto> options;
}
