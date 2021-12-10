package com.ddd.workshop.domain.ecom.v1;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
public class Cart {

    private final List<Item> items = new ArrayList<>();
    private final List<Item> removedItems = new ArrayList<>();
    private final UUID id;
    private CartState state = CartState.Open;

    public Cart() {
        this.id = UUID.randomUUID();
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "items=" + items +
                '}';
    }

    public int getItemCount() {
        return this.items.size();
    }

    public Item getItemByName(String name) {
        return this.items.stream()
                .filter(item -> item.getProduct().getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public void removeItem(Item cartItem) {
        this.items.remove(cartItem);
        this.removedItems.add(cartItem);
    }

    public List<Product> checkout() {
        List<Product> checkoutProducts = new ArrayList<>();
        this.items.stream().forEach(item-> {
            for(int i=1; i<=item.getQuantity(); i++) {
                checkoutProducts.add(item.getProduct());
            }
        });
        setCartState(CartState.CheckedOut);
        return checkoutProducts;
    }

    private void setCartState(CartState newState){
        this.state = newState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return (cart.id == id) ||
                (Objects.equals(items, cart.items) &&
                Objects.equals(removedItems, cart.removedItems) &&
                Objects.equals(id, cart.id));
    }

    @Override
    public int hashCode() {
        return Objects.hash(items, removedItems, id);
    }
}
