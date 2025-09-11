package com.wasilewskyy.product_service.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "product_configurations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductConfiguration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Enumerated(EnumType.STRING)
    private ConfigurationType type;

    private String name;
    private String value;
    private String displayName;
    private BigDecimal additionalPrice;
    private Boolean available = true;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductConfiguration productConfiguration = (ProductConfiguration) o;
        return id != null && id.equals(productConfiguration.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
