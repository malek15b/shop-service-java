package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        ProductRepo productRepo = new ProductRepo();
        Product p1 = new Product(UUID.randomUUID().toString(), "Apfel", 0.5, 10);
        Product p2 = new Product(UUID.randomUUID().toString(), "Banane", 0.8, 10);
        Product p3 = new Product(UUID.randomUUID().toString(), "Handy", 253.55, 10);

        productRepo.addProduct(p1);
        productRepo.addProduct(p2);
        productRepo.addProduct(p3);

        OrderRepoInterface orderListRepo = new OrderListRepo();
        ShopService shopService = new ShopService(orderListRepo, productRepo);
        List<OrderLineItem> lineItems = new ArrayList<>();
        lineItems.add(new OrderLineItem(p1,2));
        lineItems.add(new OrderLineItem(p2,5));
        shopService.addOrder(lineItems);

        System.out.println(productRepo.getProducts().values());

    }
}