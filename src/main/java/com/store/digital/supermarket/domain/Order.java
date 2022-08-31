package com.store.digital.supermarket.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Long orderKey;

    private User user;

    private List<Product> productItems = new ArrayList<>();

    private Double totalOrderPrice;

    private Double discountPercentage = 0D;


    public Order(){
    }

    public Order(User user, List<Product> productItems, Double totalOrderPrice, Double discountPercentage){
        this.user = user;
        this.productItems = productItems;
        this.totalOrderPrice = totalOrderPrice;
        this.discountPercentage = discountPercentage;
    }

    public void addProductToCart(Product product){
        productItems.add(product);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProductItems() {
        return productItems;
    }

    public void setProductItems(List<Product> productItems) {
        this.productItems = productItems;
    }

    public Double getTotalOrderPrice() {
        return totalOrderPrice;
    }

    public void setTotalOrderPrice(Double totalOrderPrice) {
        this.totalOrderPrice = totalOrderPrice;
    }

    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public Long getOrderKey() {
        return orderKey;
    }

    public void setOrderKey(Long orderKey) {
        this.orderKey = orderKey;
    }

    @Override
    public String toString(){
        return "Order{" +
                "\nusername: " + user.getUsername() +
                ",\ntotalOrderPrice: " + totalOrderPrice +
                ", \nProducts: " + productItems +
                '}';
     }
}
