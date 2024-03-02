package com.oscar2.ubicua2.repository;

import com.oscar2.ubicua2.entity.orderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface oneToManyRepository extends JpaRepository<orderItem,Long> {

}
