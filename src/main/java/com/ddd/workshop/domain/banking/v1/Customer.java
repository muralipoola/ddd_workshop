package com.ddd.workshop.domain.banking.v1;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Customer extends Entity<Integer> {

    private Address address;
    private final List<Account> accounts = new ArrayList<>();

    public Customer(Integer id, Address address) {
        super(id);
        this.address = address;
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public void updateAddress(Address address) {
        this.address = address;
        this.accounts.forEach(account -> account.updateAddress(address));
    }

    @Override
    String getEntityType() {
        return "customer";
    }
}
