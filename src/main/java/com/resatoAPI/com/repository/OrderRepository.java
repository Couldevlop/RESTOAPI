package com.resatoAPI.com.repository;

import com.resatoAPI.com.entity.Order;
import com.resatoAPI.com.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
        List<Order> findAllByStatus(Status status);


}
