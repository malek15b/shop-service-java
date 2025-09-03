package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderMapRepo implements OrderRepoInterface {
    private Map<String, Order> orders;
    private Integer currentId = 1;

    public OrderMapRepo(Map<String, Order> orders) {
        this.orders = orders;
    }

    public OrderMapRepo() {
        this.orders = new HashMap<>();
    }

    @Override
    public void add(Order order) {
        this.orders.put(order.id(), order);
        currentId++;
    }

    @Override
    public void remove(String orderId) {
        this.orders.remove(orderId);
    }

    @Override
    public Order getSingle(String orderId) {
        return orders.get(orderId);
    }

    @Override
    public List<Order> getAll() {
        return new ArrayList<>(orders.values());
    }

    @Override
    public Integer getCurrentId() {
        return this.currentId;
    }

}
