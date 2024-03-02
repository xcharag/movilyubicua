package com.oscar2.ubicua2.repository;

import com.oscar2.ubicua2.entity.order;
import com.oscar2.ubicua2.entity.orderItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class oneToManyRepositoryTest {
    @Autowired
    private oneToManyRepository oneToManyRepository;

    @Autowired
    private productRepository productRepository;

    @Autowired
    private orderRepository orderRepository;

    @Test
    void saveMethod(){
        order Order = new order();
        Order.setOrderTrackingNumber("100AAA");
        Order.setStatus("In progress");

        orderItem OrderItem = new orderItem();
        OrderItem.setProduct(productRepository.findById(1L).get());
        OrderItem.setQuantity(2);
        OrderItem.setPrice(OrderItem.getProduct().getPrice().multiply(new BigDecimal(2)));
        OrderItem.setImgUrl("Foto.png");
        Order.getOrderItems().add(OrderItem);

        orderItem OrderItem2 = new orderItem();

    }
}