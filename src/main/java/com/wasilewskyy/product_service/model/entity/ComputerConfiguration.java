package com.wasilewskyy.product_service.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "computer_configurations")
public class ComputerConfiguration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "computer_id", nullable = false)
    private Computer computer;
    private ConfigurationType type;
    private String name;
    private String value;
    private String displayName;
    private BigDecimal additionalPrice;
    private Boolean available;
}

