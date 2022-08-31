package com.store.digital.supermarket.repository;

import com.store.digital.supermarket.domain.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductRepository {
    Long defaultSKU = 100L;

    private Map<Long, Product> products = new HashMap<>();

    public  Map<Long, Product> getAllProducts(){
        return products;
    }

    public Product save(Product product){
        defaultSKU++;
        product.setSKU(defaultSKU);
        products.put(product.getSKU(), product);
        return product;
    }
}
