package com.store.digital.supermarket.service;

import com.store.digital.supermarket.domain.Order;

public interface OrderService {

    void createOrder(Order order);

    String getOrderReport();
}
