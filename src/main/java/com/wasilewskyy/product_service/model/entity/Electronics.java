package com.wasilewskyy.product_service.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "electronics")
public class Electronics extends Product {

    private String brand;
    private String model;
    private Integer warrantyMonths;
}

