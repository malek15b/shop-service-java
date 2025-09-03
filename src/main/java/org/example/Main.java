package org.example;

public class Main {
    public static void main(String[] args) {
        OrderListRepo orderListRepo = new OrderListRepo();
        ShopService shopService = new ShopService(orderListRepo);
    }
}