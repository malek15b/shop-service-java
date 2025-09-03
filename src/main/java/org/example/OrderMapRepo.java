package org.example;

import java.util.Map;

public class OrderMapRepo implements OrderRepoInterface {
    @Override
    public void add(Order order) {

    }

    @Override
    public void remove(String orderId) {

    }

    @Override
    public Order getSingle(String orderId) {
        return null;
    }

    @Override
    public Map<String, Order> getAll() {
        return Map.of();
    }
}
