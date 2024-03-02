package com.oscar2.ubicua2.repository;

import com.oscar2.ubicua2.entity.address;
import com.oscar2.ubicua2.entity.order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class orderRepositoryTest {
    @Autowired
    private orderRepository orderRepository;

    //UNIDIRECCIONAL

    @Test
    void saveMethod(){

        order Order = new order();
        Order.setOrderTrackingNumber("5432");
        Order.setStatus("En Proceso");
        Order.setTotalPrice(new BigDecimal(600));
        Order.setTotalQuantity(30);

        address Address = new address();
        Address.setCity("New Jersey");
        Address.setCountry("Estados Unidos");
        Address.setStreet("Calle Guayaramerin, #2566");
        Address.setState("New Jersey");
        Address.setZipcode("4111");

        Order.setBillingAddress(Address);

        orderRepository.save(Order);
    }

    @Test
    void updateMethod(){
        order Order = orderRepository.findById(6L).get();
        Order.setStatus("Entregado");
        Order.getBillingAddress().setZipcode("1111");
        orderRepository.save(Order);
    }
}