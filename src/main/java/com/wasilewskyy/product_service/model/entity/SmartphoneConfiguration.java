package com.wasilewskyy.product_service.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "smartphone_configurations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SmartphoneConfiguration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Smartphone smartphone;
    private ConfigurationType type;
    private String name;
    private String value;
    private String displayName;
    private BigDecimal additionalPrice;
    private Boolean available;
}

