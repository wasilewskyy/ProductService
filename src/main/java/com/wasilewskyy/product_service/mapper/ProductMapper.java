package com.wasilewskyy.product_service.mapper;

import com.wasilewskyy.product_service.model.dto.ProductConfigurationDto;
import com.wasilewskyy.product_service.model.dto.ProductDto;
import com.wasilewskyy.product_service.model.entity.Product;
import com.wasilewskyy.product_service.model.entity.ProductConfiguration;
import com.wasilewskyy.product_service.model.request.CreateProductRequest;
import com.wasilewskyy.product_service.model.request.UpdateProductRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto toDto(Product product);

    Product toEntity(CreateProductRequest request);

    void updateEntity(@MappingTarget Product product, UpdateProductRequest request);

    ProductConfigurationDto toConfigurationDto(ProductConfiguration config);
}