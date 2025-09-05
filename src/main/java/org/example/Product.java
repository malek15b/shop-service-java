package org.example;

public record Product(String id, String name, double price, int stock) {
    public Product subStock(int sub) {
        int neuStock = stock - sub;
        if (neuStock < 0) {
            return null;
        }
        return new Product(id, name, price, neuStock);
    }
}
