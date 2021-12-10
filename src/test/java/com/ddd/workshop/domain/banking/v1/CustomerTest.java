package com.ddd.workshop.domain.banking.v1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {

    @Test
    public void mustUpdateAccountAddressWhenCustomerAddressIsChanged(){
        Address address = new Address("Hyderabad");

        Account account1 = new Account(123, address);
        Account account2 = new Account(345, address);

        Customer customer = new Customer(1, address);
        customer.addAccount(account1);
        customer.addAccount(account2);
        customer.updateAddress(address.update("Bangalore"));

        assertEquals(customer.getAddress(), customer.getAccounts().get(0).getAddress());
    }
}