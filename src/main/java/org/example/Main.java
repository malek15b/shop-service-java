package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductRepo productRepo = new ProductRepo();
        Product p1 = new Product("1", "Apfel", 0.5);
        Product p2 = new Product("2", "Banane", 0.8);
        Product p3 = new Product("3", "Handy", 253.55);

        productRepo.addProduct(p1);
        productRepo.addProduct(p2);
        productRepo.addProduct(p3);

        OrderRepoInterface orderListRepo = new OrderListRepo();
        ShopService shopService = new ShopService(orderListRepo, productRepo);
        List<OrderLineItem> lineItems = new ArrayList<>();
        lineItems.add(new OrderLineItem(p1,2));
        lineItems.add(new OrderLineItem(p2,5));
        shopService.addOrder(lineItems);

        System.out.println(orderListRepo.getAll());
    }
}