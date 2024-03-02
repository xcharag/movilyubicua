package com.oscar2.ubicua2.repository;

import com.oscar2.ubicua2.entity.address;
import com.oscar2.ubicua2.entity.order;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class addressRepositoryTest {
    @Autowired
    private addressRepository addressRepository;

    //BIDIRECCIONAL

    @Test
    void saveMethod(){
        order Order = new order();
        Order.setOrderTrackingNumber("5432");
        Order.setStatus("En Proceso");
        Order.setTotalPrice(new BigDecimal(600));
        Order.setTotalQuantity(30);

        address Address = new address();
        Address.setCity("Santa Cruz de la Sierra");
        Address.setCountry("Bolivia");
        Address.setStreet("Calle Los Junos, #2149");
        Address.setState("Santa Cruz");
        Address.setZipcode("0000");

        Order.setBillingAddress(Address);
        Address.setOrder(Order);

        addressRepository.save(Address);
    }

    @Test
    void deleteAllMethod(){
        addressRepository.deleteAll();
    }

    @Test
    void findMethod(){
        address Address = addressRepository.findById(1L).get();
    }

    @Test
    void findAllMethod(){
        List<address> objAddress = addressRepository.findAll();
    }
}