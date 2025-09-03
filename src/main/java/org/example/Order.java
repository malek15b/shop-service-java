package org.example;

import java.util.List;
import java.util.Map;

public record Order(String id, List<OrderLineItem> orderLineItem) {
    public double getTotalOrderPrice() {
        double total = 0;
        for (OrderLineItem item : orderLineItem) {
            total += item.getTotalPrice();
        }
        return total;
    }
}
