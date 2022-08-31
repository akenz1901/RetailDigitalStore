package com.store.digital.supermarket.service;

import com.store.digital.supermarket.domain.Order;
import com.store.digital.supermarket.domain.Product;
import com.store.digital.supermarket.domain.ProductType;
import com.store.digital.supermarket.domain.Role;
import com.store.digital.supermarket.repository.OrderRepository;

import java.text.ParseException;
import java.time.LocalDateTime;


public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private String reportStatement;

    public OrderServiceImpl(){
        orderRepository = new OrderRepository();
    }

    @Override
    public void createOrder(Order order) {
        reportStatement = "";
        try {
            order = calculateDiscount(order);
            double groceryPrices = order.getProductItems()
                    .stream()
                    .filter(product -> product.getProductType() == ProductType.GROCERY)
                    .map(Product::getPrice)
                    .reduce(0.0,Double::sum);
            groceryPrices += order.getTotalOrderPrice();
            order.setTotalOrderPrice(groceryPrices);
            orderRepository.save(order);
            reportStatement += "\n" + order + "\nNo discount on all added groceries if you have any in your cart!!!";
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private Order calculateDiscount(Order order) throws ParseException {
        double totalAmountWithDiscount;
        double discount = 0;
        double amount = order.getProductItems().stream()
                .filter(product -> product.getProductType() != ProductType.GROCERY)
                .map(Product::getPrice)
                .reduce(0.0, Double::sum);

        if(order.getUser().getRole().equals(Role.EMPLOYEE)){
            discount = 0.3;
            order.setDiscountPercentage(discount);
            totalAmountWithDiscount = amount - amount * order.getDiscountPercentage();
            order.setTotalOrderPrice(totalAmountWithDiscount);
            reportStatement = "As the customer is an Employee this means customer is entitled to %30 " +
                    "discount for this purchase\n";
        }
        else if(order.getUser().getRole().equals(Role.AFFILIATE)){
            discount = 0.1;
            order.setDiscountPercentage(discount);
            totalAmountWithDiscount = amount - amount * order.getDiscountPercentage();
            order.setTotalOrderPrice(totalAmountWithDiscount);
            reportStatement = "As the customer is an Affiliate this means customer is entitled to %10 " +
                    "discount for this purchase.\n";
        }

        if(order.getUser().getDateJoined().getYear() < LocalDateTime.now().getYear()){
            discount += 0.05;
            order.setDiscountPercentage(discount);
            totalAmountWithDiscount = amount - amount * order.getDiscountPercentage();
            order.setTotalOrderPrice(totalAmountWithDiscount);
            reportStatement += "Customer has also been patronizing the store for the " +
                    "past two years this grants the customer %5 discount.";
        }
        return order;
    }

    @Override
    public String getOrderReport() {
        return reportStatement;
    }
}
