package org.example;

public class OrderLineItem {
    private final Product product;
    private int quantity;

    public OrderLineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        }
    }

    public double getTotalPrice() {
        return product.price() * quantity;
    }

    @Override
    public String toString() {
        return "OrderLineItem{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}