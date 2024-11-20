package com.resatoAPI.com.service;

import com.resatoAPI.com.dto.OrderItemDTO;
import com.resatoAPI.com.repository.OrderItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderItemServiceImpl implements OrderItemService{
    private final OrderItemRepository orderItemRepository;

    public OrderItemServiceImpl(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public OrderItemDTO save(OrderItemDTO dto) {
        return null;
    }

    @Override
    public OrderItemDTO findById(Long id) {
        return null;
    }

    @Override
    public List<OrderItemDTO> getAll() {
        return null;
    }

    @Override
    public OrderItemDTO update(Long id, OrderItemDTO dto) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
