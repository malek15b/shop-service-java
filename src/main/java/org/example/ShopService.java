package org.example;

import java.util.HashMap;
import java.util.List;

public class ShopService {

    private final OrderListRepo orderListRepo;
    private final ProductRepo productRepo;

    public ShopService(OrderListRepo orderListRepo, ProductRepo productRepo) {
        this.orderListRepo = orderListRepo;
        this.productRepo = productRepo;
    }

    public ShopService(OrderListRepo orderListRepo) {
        this.orderListRepo = orderListRepo;
        this.productRepo = new ProductRepo();
    }

    public void addOrder(List<Product> products) {
        int orderSize = this.orderListRepo.getOrders().size();
        Order order = new Order("o" + orderSize, new HashMap<>());
        for (Product p : products) {
            Product product = productRepo.getProduct(p.id());
            if (product != null) {
                order.products().put(p.id(), p);
            } else {
                System.out.println("Bestellung nicht möglich: Product existiert nicht.");
                return;
            }
        }
        orderListRepo.addOrder(order);
    }
}
