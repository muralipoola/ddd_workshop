package com.ddd.workshop.domain.ecom.v1;

import lombok.Getter;

@Getter
public class Product {

    private final String name;
    private Price price;
    private float weightInGrams;

    public Product(String name, Price price) {
        this.name   = name;
        this.price = price;
        this.weightInGrams = 0;
    }

    public Product(String name, Price price, float weightInGrams) {
        this(name, price);
        this.weightInGrams = weightInGrams;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                '}';
    }

}
