package com.store.digital.supermarket.repository;

import com.store.digital.supermarket.domain.Product;
import com.store.digital.supermarket.domain.ProductType;
import com.store.digital.supermarket.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    private ProductRepository productRepository;

    @BeforeEach
    void setUp(){
        productRepository =  new ProductRepository();
    }

    @Test
    void productCanBeSaved(){
        // given product is created
        Product product = new Product();
        product.setName("HP Elite Book 850");
        product.setProductType(ProductType.GADGET);
        product.setPrice(150000D);

        // then product can be saved
        productRepository.save(product);
        Map<Long, Product> products = productRepository.getAllProducts();
        assertTrue(products.containsKey(101L));
        assertEquals(products.get(101L), product);
        assertTrue(products.size() != 0);
    }

}