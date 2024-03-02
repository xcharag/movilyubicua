package com.oscar2.ubicua2.repository;

import com.oscar2.ubicua2.entity.product;
import com.oscar2.ubicua2.entity.productCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class productCategoryRepositoryTest {
    @Autowired
    private productCategoryRepository productCategoryRepository;
    @Autowired
    private productCategory productCategory;
    @Autowired
    private product product;

    @Test
    void saveMethod() {
        productCategory productCategory = new productCategory();
        productCategory.setCategoryName("Libros");
        productCategory.setCategoryDescription("Libros Digitales");

        product product1 = new product();
        product1.setName("CLean Code V1");
        product1.setDescription("El primer libro de clean code del mundo mundial");
        product1.setPrice(new BigDecimal(9999));
        product1.setSku("CLCO001");
        product1.setActive(true);
        product1.setUrlimage("fotito.png");
        product1.setCategory(productCategory);
        productCategory.getProducts().add(product1);

        product product2 = new product();
        product2.setName("Mi libro Luna Pluton");
        product2.setDescription("El libro de Dross");
        product2.setPrice(new BigDecimal(1111));
        product2.setSku("MLLP001");
        product2.setActive(true);
        product2.setUrlimage("fotaso.png");
        product2.setCategory(productCategory);
        productCategory.getProducts().add(product2);

        productCategoryRepository.save(productCategory);
    }
    }
}