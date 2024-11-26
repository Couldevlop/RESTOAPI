package com.resatoAPI.com.service.impl;

import com.resatoAPI.com.dto.OrderDTO;
import com.resatoAPI.com.repository.OrderRepository;
import com.resatoAPI.com.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderDTO save(OrderDTO dto) {
        return null;
    }

    @Override
    public OrderDTO findById(Long id) {
        return null;
    }

    @Override
    public List<OrderDTO> getAll() {
        return null;
    }

    @Override
    public OrderDTO update(Long id, OrderDTO dto) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
