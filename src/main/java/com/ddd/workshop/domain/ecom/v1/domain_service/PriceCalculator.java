package com.ddd.workshop.domain.ecom.v1.domain_service;


import com.ddd.workshop.domain.ecom.v1.Price;
import com.ddd.workshop.domain.ecom.v1.Product;

import java.util.Currency;

public class PriceCalculator {

    private final CompetitorPricing competitorPricing;
    private Currency baseCurrency = Currency.getInstance("INR");

    public PriceCalculator(CompetitorPricing competitorPricing) {
        this.competitorPricing = competitorPricing;
    }

    public Price getPrice(Product product) {
        Price competitorPrice = competitorPricing.getPrice(product.getName());
        if (competitorPrice!= null){
            return competitorPrice.reduceByPercentage(10);
        }
        else
        {
            return product.getPrice();
        }
    }

    private Price reducePrice(Price price){
        return new Price(price.getAmount()*90/100, baseCurrency);
    }
}
