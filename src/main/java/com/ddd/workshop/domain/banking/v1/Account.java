package com.ddd.workshop.domain.banking.v1;

import lombok.Getter;

@Getter
public class Account extends Entity<Integer> {

    private Address address;

    public Account(Integer id, Address address) {
        super(id);
        this.address = address;
    }

    @Override
    String getEntityType() {
        return "account";
    }

    public void updateAddress(Address address) {
        this.address = address;
    }
}
