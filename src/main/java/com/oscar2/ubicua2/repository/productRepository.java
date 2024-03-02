package com.oscar2.ubicua2.repository;

import com.oscar2.ubicua2.entity.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productRepository extends JpaRepository<product, Long> {

}
