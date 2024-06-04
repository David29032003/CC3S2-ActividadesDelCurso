package org.example;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class NumberUtilsTest3 {
    @Test
    void testEmptyCart() {
        ShoppingCart cart = new ShoppingCart();
        assertThat(cart.totalPrice()).isEqualTo(0.0);
    }

    @Test void testSingleItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.add(new CartItem("Product 1", 2, 5.0));
        assertThat(cart.totalPrice()).isEqualTo(10.0);
    }

    @Test void testMultipleItems() {
        ShoppingCart cart = new ShoppingCart();
        cart.add(new CartItem("Product 1", 2, 5.0));
        cart.add(new CartItem("Product 2", 1, 15.0));
        assertThat(cart.totalPrice()).isEqualTo(25.0);
    }

    @Test void testDifferentQuantitiesAndPrices() {
        ShoppingCart cart = new ShoppingCart();
        cart.add(new CartItem("Product 1", 1, 10.0));
        cart.add(new CartItem("Product 2", 3, 7.5));
        cart.add(new CartItem("Product 3", 5, 2.0));
        assertThat(cart.totalPrice()).isEqualTo(42.5);
    }
}
