package com.resatoAPI.com.repository;

import com.resatoAPI.com.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    Boolean findByName(String name);
}
