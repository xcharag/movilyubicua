package com.oscar2.ubicua2.repository;

import com.oscar2.ubicua2.entity.order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface orderRepository extends JpaRepository<order,Long> {
    order findByorderTrackingNumber(String orderTrackingNumber);
}
