package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShopService {

    private final OrderRepoInterface orderListRepo;
    private final ProductRepo productRepo;

    public ShopService(OrderRepoInterface orderListRepo, ProductRepo productRepo) {
        this.orderListRepo = orderListRepo;
        this.productRepo = productRepo;
    }

    public Order addOrder(List<OrderLineItem> lineItems) {
        Order order = new Order(UUID.randomUUID().toString(), new ArrayList<>());
        for (OrderLineItem item : lineItems) {
            System.out.println(item.getProduct());
            Product product = productRepo.getProduct(item.getProduct().id());
            if (product != null) {
                order.orderLineItem().add(item);
            } else {
                System.out.println("Bestellung nicht möglich: Produkt existiert nicht.");
                return null;
            }
        }
        orderListRepo.add(order);
        return order;
    }

    public void setQuantity(OrderLineItem orderLineItem, int quantity) {
        orderLineItem.setQuantity(quantity);
    }
}
