package com.oscar2.ubicua2.repository;

import com.oscar2.ubicua2.entity.address;
import lombok.Builder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface addressRepository extends JpaRepository<address,Long> {
}
