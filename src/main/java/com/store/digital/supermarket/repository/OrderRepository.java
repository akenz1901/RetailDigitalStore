package com.store.digital.supermarket.repository;

import com.store.digital.supermarket.domain.Order;
import com.store.digital.supermarket.domain.Product;

import java.util.HashMap;
import java.util.Map;

public class OrderRepository {

    Long defaultOrderKey = 1111L;

    private Map<Long, Order> orders = new HashMap<>();

    public  Map<Long, Order> getAllOrders(){
        return orders;
    }

    public void save(Order order){
        defaultOrderKey++;
        order.setOrderKey(defaultOrderKey);
        orders.put(order.getOrderKey(), order);
    }
}
