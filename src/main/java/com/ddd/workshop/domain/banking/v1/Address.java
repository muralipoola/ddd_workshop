package com.ddd.workshop.domain.banking.v1;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Address {
    private String city;

    public Address(String city) {
        this.city = city;
    }

    public Address update(String city) {
        return new Address(city);
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return city.equals(address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city);
    }
}
