package com.ddd.workshop.domain.ecom.v1;

import lombok.Getter;

import java.util.Currency;
import java.util.Objects;

@Getter
public class Price {
    private final Currency currency;
    private final float amount;

    public Price(float amount, Currency currency) {
        this.currency = currency;
        this.amount = amount;
    }

    public Price reduceByPercentage(float percentage) {
        return new Price(this.getAmount() - (this.getAmount() * percentage / 100), currency);
    }

    @Override
    public String toString() {
        return "Price{" +
                "currency=" + currency +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return Float.compare(price.amount, amount) == 0 && currency.equals(price.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, amount);
    }
}
