package org.example;

import java.util.ArrayList;
import java.util.List;

public class OrderListRepo implements OrderRepoInterface {

    private List<Order> orders;
    private Integer currentId = 1;

    public OrderListRepo(List<Order> orders) {
        this.orders = orders;
    }

    public OrderListRepo() {
        this.orders = new ArrayList<>();
    }

    @Override
    public void add(Order order) {
        this.orders.add(order);
        currentId++;
    }

    @Override
    public void remove(String orderId) {
        Order order = this.getSingle(orderId);
        this.orders.remove(order);
    }

    @Override
    public Order getSingle(String orderId) {
        for (Order order : this.orders) {
            if (order.id().equals(orderId)) {
                return order;
            }
        }
        return null;
    }

    @Override
    public List<Order> getAll() {
        return this.orders;
    }

    @Override
    public Integer getCurrentId() {
        return this.currentId;
    }
}
