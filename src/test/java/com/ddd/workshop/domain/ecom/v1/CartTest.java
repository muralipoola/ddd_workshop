package com.ddd.workshop.domain.ecom.v1;

import com.ddd.workshop.domain.ecom.v1.domain_service.CompetitorPricing;
import com.ddd.workshop.domain.ecom.v1.domain_service.PriceCalculator;
import org.junit.jupiter.api.Test;

import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    Currency baseCurrency = Currency.getInstance("INR");
    Price price = new Price(100, baseCurrency);

    @Test
    public void mustAddIPadProItemToCart() {
        Cart cart = new Cart();
        String productName = "IPad Pro";

        Product product = new Product(productName, price);
        int quantity = 1;
        cart.addItem(new Item(product, quantity));

        assertEquals(cart.getItemCount(), quantity);
        assertNotNull(cart.getItemByName(productName));
    }

    @Test
    public void mustAddHeroInkPenItemToCart() {
        Cart cart = new Cart();
        String productName = "Hero ink Pen";
        Product product = new Product(productName, price);
        int quantity = 1;
        cart.addItem(new Item(product, quantity));

        assertEquals(cart.getItemCount(), quantity);
        assertNotNull(cart.getItemByName(productName));
    }

    @Test
    public void mustAddMultipleQuantitiesOfCricketBatToCart() {
        Cart cart = new Cart();
        String productName = "GM Cricket bat";
        Product product = new Product(productName, price);
        int quantity = 2;
        cart.addItem(new Item(product, quantity));

        Item addedItem = cart.getItemByName(productName);
        assertNotNull(addedItem);
        assertEquals(addedItem.getQuantity(), quantity);
    }

    @Test
    public void mustRemoveAnExistingItemFromTheCart() {
        Cart cart = new Cart();
        String productName = "GM Cricket bat";
        Product product = new Product(productName, price);
        int quantity = 2;
        Item cartItem = new Item(product, quantity);
        cart.addItem(cartItem);

        cart.removeItem(cartItem);

        Item addedItem = cart.getItemByName(productName);
        assertNull(addedItem);
        assertEquals(cart.getItemCount(), 0);
    }

    @Test
    public void mustReturnDeletedProductsFromCart() {
        Cart cart = new Cart();
        String productName = "GM Cricket bat";
        Product product = new Product(productName, price);
        int quantity = 2;
        Item cartItem = new Item(product, quantity);
        cart.addItem(cartItem);

        cart.removeItem(cartItem);

        List<String> removedItems = cart.getRemovedItems()
                .stream()
                .map(item -> cartItem.getProduct().getName())
                .toList();

        assertTrue(removedItems.contains(productName));
    }

    @Test
    public void mustCompareTwoCartsOnEquality() {
        Cart cart1 = new Cart();
        Cart cart2 = new Cart();

        Item item1 = new Item(new Product("Ipad", price), 1);
        Item item2 = new Item(new Product("Ipad", price), 1);

        cart1.addItem(item1);
        cart2.addItem(item2);

        assertNotEquals(cart1, cart2);
    }

    @Test
    public void mustOfferPriceLessThanCompetitorPrice() {
        String productName = "Ipad";
        Product product = new Product(productName, price);

        Map<String, Price> priceMap = new HashMap<>();
        priceMap.put(productName, new Price(100, baseCurrency));

        CompetitorPricing competitorPricing = new CompetitorPricing(priceMap);
        PriceCalculator priceCalculator = new PriceCalculator(competitorPricing);
        Price discountedPrice = priceCalculator.getPrice(product);
        Price expectedPrice = product.getPrice().reduceByPercentage(10);

        assertEquals(expectedPrice.getAmount(), discountedPrice.getAmount());
    }

    @Test
    public void mustCalculateTotalCostForTheOrder() {
        Cart cart = new Cart();
        Item item1 = new Item(new Product("Ipad", new Price(100, baseCurrency), 100), 1);
        Item item2 = new Item(new Product("Ipad", new Price(200, baseCurrency), 200), 1);

        cart.addItem(item1);
        cart.addItem(item2);

        List<Product> products =  cart.checkout();
        Order order = new Order(products);
        float totalPrice = order.getTotalCost();
        float expectedPrice = 303;

        assertEquals(expectedPrice, totalPrice);
    }
}