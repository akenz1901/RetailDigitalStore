package com.store.digital.supermarket;

import com.store.digital.supermarket.domain.*;
import com.store.digital.supermarket.repository.ProductRepository;
import com.store.digital.supermarket.repository.UserRepository;
import com.store.digital.supermarket.service.OrderService;
import com.store.digital.supermarket.service.OrderServiceImpl;

import java.time.LocalDateTime;

public class RetailStoreDiscountApp {

    public static void main(String[] args) {
        System.out.println(setUp());
    }

    private static String setUp(){
        OrderService orderService = new OrderServiceImpl();
        UserRepository userRepository = new UserRepository();
        ProductRepository productRepository = new ProductRepository();

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

        Product grocery = new Product();
        grocery.setName("Creamy Milk");
        grocery.setPrice(10_000D);
        grocery.setProductType(ProductType.GROCERY);
        grocery = productRepository.save(grocery);

        // when creating Order
        Order order = new Order();
        order.setUser(user);
        order.addProductToCart(product);
        order.addProductToCart(product1);
        order.addProductToCart(grocery);

        Order orderNew = new Order();
        orderNew.setUser(userJoinedTwoYearsAgo);
        orderNew.addProductToCart(product);
        orderNew.addProductToCart(product1);
        orderNew.addProductToCart(grocery);

        orderService.createOrder(order);

        return orderService.getOrderReport();
    }
}
