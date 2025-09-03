package org.example;

import java.util.ArrayList;
import java.util.List;

public class ShopService {

    private final OrderRepoInterface orderListRepo;
    private final ProductRepo productRepo;

    public ShopService(OrderRepoInterface orderListRepo, ProductRepo productRepo) {
        this.orderListRepo = orderListRepo;
        this.productRepo = productRepo;
    }

    public ShopService(OrderRepoInterface orderListRepo) {
        this.orderListRepo = orderListRepo;
        this.productRepo = new ProductRepo();
    }

    public void addOrder(List<OrderLineItem> lineItems) {
        Order order = new Order(orderListRepo.getCurrentId() + "", new ArrayList<>());
        for (OrderLineItem item : lineItems) {
            Product product = productRepo.getProduct(item.getProduct().id());
            if (product != null) {
                order.orderLineItem().add(item);
            } else {
                System.out.println("Bestellung nicht möglich: Product existiert nicht.");
                return;
            }
        }
        orderListRepo.add(order);
    }
}
