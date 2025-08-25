package com.wasilewskyy.product_service.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "smartphones")
@Data
@NoArgsConstructor
public class Smartphone extends Product {

    private String baseColor;
    private String baseBatteryCapacity;
    private String baseStorage;

    @OneToMany(mappedBy = "smartphone", cascade = CascadeType.ALL)
    private List<SmartphoneConfiguration> availableConfigurations = new ArrayList<>();
}