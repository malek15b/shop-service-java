package org.example;

import java.util.Map;

public interface OrderRepoInterface {

    public void add(Order order);

    public void remove(String orderId);

    public Order getSingle(String orderId);

    public Map<String, Order> getAll();
}
