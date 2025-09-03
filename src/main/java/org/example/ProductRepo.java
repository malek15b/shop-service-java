package org.example;

import java.util.HashMap;
import java.util.Map;

public class ProductRepo {
    Map<String, Product> products;

    public ProductRepo(Map<String, Product>  products) {
        this.products = products;
    }

    public ProductRepo() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        this.products.put(product.id(), product);
    }

    public void removeProduct(String productId) {
        this.products.remove(productId);
    }

    public Product getProduct(String productId) {
        return products.get(productId);
    }

    public Map<String, Product> getProducts() {
        return this.products;
    }
}
