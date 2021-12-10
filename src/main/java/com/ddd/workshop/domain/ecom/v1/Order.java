package com.ddd.workshop.domain.ecom.v1;

import lombok.Getter;

import java.util.List;

@Getter
public class Order {
    private List<Product> orderedProducts;
    float totalCost = 0;

    public Order(List<Product> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }

    public float getTotalCost() {
        orderedProducts.forEach(product-> {
            totalCost =  totalCost + product.getPrice().getAmount() ;
            totalCost = totalCost + (product.getWeightInGrams()  *.01f);
        });
        return totalCost;
    }
}
