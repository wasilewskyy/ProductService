package com.wasilewskyy.product_service.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "computers")
public class Computer extends Product {

    private String baseProcessor;
    private String baseRam;
    private String baseStorage;

    @OneToMany(mappedBy = "computer", cascade = CascadeType.ALL)
    private List<ComputerConfiguration> availableConfigurations = new ArrayList<>();

}