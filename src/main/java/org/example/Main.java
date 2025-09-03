package org.example;

public class Main {
    public static void main(String[] args) {
        OrderRepoInterface orderListRepo = new OrderListRepo();
        ShopService shopService = new ShopService(orderListRepo);
    }
}