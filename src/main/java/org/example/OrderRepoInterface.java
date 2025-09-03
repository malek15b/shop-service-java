package org.example;

import java.util.List;

public interface OrderRepoInterface {

    public void add(Order order);

    public void remove(String orderId);

    public Order getSingle(String orderId);

    public List<Order> getAll();
}
