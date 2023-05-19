/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.product;

import com.javatunes.billing.Location;
import com.javatunes.billing.TaxCalculator;
import com.javatunes.billing.TaxCalculatorFactory;

import java.util.Collection;

public class Order {
    private String id;
    public Location location;
    private double cartTotal;

    public Order(String id, Location location) {     // at order creation we need id and location of order so we pass it to this method
        this.id = id;                               // direct id assignment because we have no setter below
        this.location = location;                   // direct id assignment because we have no setter below
    }

    public double getTax() {
        TaxCalculator calc = TaxCalculatorFactory.getTaxCalculator(getLocation()); // here is where we pass our location to our taxFactory so it can decide WHICH tax Class to use
        return calc.taxAmount(getCartTotal());      // delegate to it for the calculations
    }

    /**
     * DONE:
     * get the items from the cart and iterate over them, print each item's product code
     * get cart total and print
     */
    public void processCart(ShoppingCart<? extends Product> cart) {
        System.out.println("Order: " + getId() + " contains the following:");

        Collection<? extends Product> cartItems = cart.allItems();
        for (Product product : cartItems) {
            System.out.println(product.getCode());
        }
        cartTotal = cart.total();

        System.out.println("Order Total: " + cart.total());
    }

    public String getId() {
        return id;
    }
    public double getCartTotal() {
        return  cartTotal;
    }

    public Location getLocation() {
        return location;
    }
}