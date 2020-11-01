package com.kodilla.kodillapatterns2.facade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private ProductService prductService;
    private final List<Item> items = new ArrayList<>();
    private final Long orderId;
    private final Long userId;
    private boolean isPaid = false;
    private boolean isVerified = false;
    private boolean isSubmitted = false;

    public Order(ProductService prductService, Long orderId, Long userId) {
        this.prductService = prductService;
        this.orderId = orderId;
        this.userId = userId;
    }

    public BigDecimal calculateValue() {
        BigDecimal sum = BigDecimal.ZERO;
        for (Item item : items) {
            sum = sum.add(prductService.getPrice(item.getProductId()))
                    .multiply(new BigDecimal(item.getQty()));
        }
        return sum;
    }

    public List<Item> getItems() {
        return items;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public boolean isSubmitted() {
        return isSubmitted;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public void setSubmitted(boolean submitted) {
        isSubmitted = submitted;
    }
}
