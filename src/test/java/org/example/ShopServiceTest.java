package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class ShopServiceTest {

    private ShopService shopService;
    private ProductRepo productRepo;
    private OrderRepoInterface orderListRepo;

    private String p1Id = UUID.randomUUID().toString();
    private String p2Id = UUID.randomUUID().toString();
    private String p3Id = UUID.randomUUID().toString();

    @BeforeEach
    void setUp() {
        productRepo = new ProductRepo();
        Product p1 = new Product(p1Id, "Apfel", 0.5);
        Product p2 = new Product(p2Id, "Banane", 0.8);
        Product p3 = new Product(p3Id, "Handy", 253.55);

        productRepo.addProduct(p1);
        productRepo.addProduct(p2);
        productRepo.addProduct(p3);

        orderListRepo = new OrderListRepo();
        shopService = new ShopService(orderListRepo, productRepo);
    }

    @Test
    public void addOrder_TotalOrderPrice_ShouldBeCorrect() {
        List<OrderLineItem> lineItems = new ArrayList<>();
        lineItems.add(new OrderLineItem(productRepo.getProducts().get(p1Id), 2));
        lineItems.add(new OrderLineItem(productRepo.getProducts().get(p2Id), 5));
        Order order = shopService.addOrder(lineItems);

        double total = 0.5 * 2 + 5 * 0.8;
        assertEquals(total, order.getTotalOrderPrice());
    }

    @Test
    public void addOrder_TotalOrderPrice_ShouldBeCorrect_setQuantity() {
        List<OrderLineItem> lineItems = new ArrayList<>();
        OrderLineItem lineItem = new OrderLineItem(productRepo.getProducts().get(p1Id), 2);
        lineItems.add(lineItem);
        lineItems.add(new OrderLineItem(productRepo.getProducts().get(p2Id), 5));
        Order order = shopService.addOrder(lineItems);
        shopService.setQuantity(lineItem, 10);
        order = orderListRepo.getSingle(order.id());

        double total = 0.5 * 10 + 5 * 0.8;
        assertEquals(total, order.getTotalOrderPrice());
    }

    @Test
    public void addOrder_Test() {
        List<OrderLineItem> lineItems = new ArrayList<>();
        lineItems.add(new OrderLineItem(productRepo.getProducts().get(p1Id), 2));
        lineItems.add(new OrderLineItem(productRepo.getProducts().get(p3Id), 5));
        Order order = shopService.addOrder(lineItems);

        assertThat(order.orderLineItem())
                .hasSize(2)
                .extracting(item -> item.getProduct().name())
                .containsExactly("Apfel", "Handy");
    }

    @Test
    public void addOrder_ProductNotFound_ShouldReturnNull() {
        List<OrderLineItem> lineItems = new ArrayList<>();
        Product product = new Product(UUID.randomUUID().toString(), "PC", 699);
        lineItems.add(new OrderLineItem(product, 10));
        lineItems.add(new OrderLineItem(productRepo.getProducts().get(p3Id), 5));
        Order order = shopService.addOrder(lineItems);
        assertNull(order);
    }

}