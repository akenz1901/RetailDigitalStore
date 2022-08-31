package com.store.digital.supermarket.service;

import com.store.digital.supermarket.domain.*;
import com.store.digital.supermarket.repository.ProductRepository;
import com.store.digital.supermarket.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    private OrderService orderService;
    private UserRepository userRepository;
    private ProductRepository productRepository;


    @BeforeEach
    void setUp(){
        orderService = new OrderServiceImpl();
        userRepository = new UserRepository();
        productRepository = new ProductRepository();
    }

    @Test
    void createOrder() {
        // given users and products are created
        User user = new User();
        user.setFirstname("Ola");
        user.setLastname("Crescent");
        user.setUsername("Lacres210");
        user.setRole(Role.EMPLOYEE);
        user = userRepository.save(user);

        User userJoinedTwoYearsAgo = new User();
        userJoinedTwoYearsAgo.setUsername("Chiboy");
        userJoinedTwoYearsAgo.setFirstname("Chibuzor");
        userJoinedTwoYearsAgo.setLastname("Kelly");
        userJoinedTwoYearsAgo.setRole(Role.AFFILIATE);
        userJoinedTwoYearsAgo.setDateJoined(LocalDateTime.now().minusYears(2));
        userJoinedTwoYearsAgo = userRepository.save(userJoinedTwoYearsAgo);
        assertTrue(userRepository.getAllUsers().containsKey(1L));
        assertEquals(2, userRepository.getAllUsers().size());

        Product product1 = new Product();
        product1.setName("Beat By Dr Dre Headphone");
        product1.setPrice(100_000D);
        product1.setProductType(ProductType.GADGET);
        product1 = productRepository.save(product1);

        Product product = new Product();
        product.setName("Iphone Xs Max");
        product.setPrice(340_000D);
        product.setProductType(ProductType.GADGET);
        product = productRepository.save(product);
        assertTrue(productRepository.getAllProducts().containsKey(101L));
        assertEquals(2, productRepository.getAllProducts().size());

        // when creating Order
        Order order = new Order();
        order.setUser(user);
        order.addProductToCart(product);
        order.addProductToCart(product1);

        Order orderNew = new Order();
        orderNew.setUser(userJoinedTwoYearsAgo);
        orderNew.addProductToCart(product);
        orderNew.addProductToCart(product1);

        // given
        orderService.createOrder(order);
        assertTrue(orderService.getOrderReport().contains("to %30"));

        orderService.createOrder(orderNew);
        assertFalse(orderService.getOrderReport().contains("to %30"));
        assertTrue(orderService.getOrderReport().contains("%5 discount"));
        assertTrue(orderService.getOrderReport().contains("to %10"));

    }
}