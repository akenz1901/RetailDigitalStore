package com.store.digital.supermarket.domain;

public class Product {

    private String name;

    private Long SKU;

    private Double price;

    private ProductType productType;

    public Product(String name, Long SKU, Double price, ProductType productType) {
        this.name = name;
        this.SKU = SKU;
        this.price = price;
        this.productType = productType;
    }
    public Product(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSKU() {
        return SKU;
    }

    public void setSKU(Long SKU) {
        this.SKU = SKU;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    @Override
    public String toString(){
        return "Product{" +
                "name =" + name +
                ", SKU =" + SKU +
                "price =" + price +
                '}';
    }
}
