package org.example;

import java.util.HashMap;
import java.util.Map;

public class OrderListRepo {
    private Map<String, Order> orders;

    public OrderListRepo(Map<String, Order> orders) {
        this.orders = orders;
    }

    public OrderListRepo() {
        this.orders = new HashMap<>();
    }

    public void addOrder(Order order) {
        this.orders.put(order.id(), order);
    }

    public void removeOrder(String orderId) {
        this.orders.remove(orderId);
    }

    public Order getOrder(String orderId) {
        return orders.get(orderId);
    }

    public Map<String, Order> getOrders() {
        return orders;
    }

}
