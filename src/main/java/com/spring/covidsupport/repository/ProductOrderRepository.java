package com.spring.covidsupport.repository;

import com.spring.covidsupport.entity.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long> {
    
}
