package com.wasilewskyy.product_service.model.entity;

public enum ProductType {
    COMPUTER("MacBook Pro"),
    SMARTPHONE("Iphone"),
    ELECTRONICS("Samsung TV"),;

    private final String name;

    ProductType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
