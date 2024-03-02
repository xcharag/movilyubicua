package com.oscar2.ubicua2.repository;

import com.oscar2.ubicua2.entity.product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class productRepositoryTest {
    @Autowired
    private productRepository productRepository;

    @Test
    void saveMethod(){
        product Product = new product();

        Product.setName("Ratas en Sardinadas");
        Product.setSku("100");
        Product.setDescription("Unas ratitas pre cocidas guardadas en latas de sardinas");
        Product.setPrice(new BigDecimal(20));
        Product.setUrlimage("ratitas.png");

        product objproduct = productRepository.save(Product); //Almacenar nuestro objeto recien creado

    }

    @Test
    void findMethod(){
        product Product = productRepository.findById(1L).get();
        System.out.println(Product);
    }

    @Test
    void deleteMethod(){
        productRepository.deleteById(1L);
    }

    @Test
    void findAllMethod(){
        List<product> Product = productRepository.findAll();
    }
}