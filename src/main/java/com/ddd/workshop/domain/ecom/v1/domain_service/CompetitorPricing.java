package com.ddd.workshop.domain.ecom.v1.domain_service;

import com.ddd.workshop.domain.ecom.v1.Price;

import java.util.HashMap;
import java.util.Map;

public class CompetitorPricing {
    private Map<String, Price> priceMap = new HashMap<>();

    public CompetitorPricing(Map<String, Price> priceMap) {
       this.priceMap = priceMap;
    }

    public Price getPrice(String productName) {
        return priceMap.get(productName);
    }
}
