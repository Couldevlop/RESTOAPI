package com.resatoAPI.com.repository;

import com.resatoAPI.com.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
