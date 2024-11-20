package com.resatoAPI.com.service;

import com.resatoAPI.com.dto.OrderDTO;
import com.resatoAPI.com.dto.OrderItemDTO;

import java.util.List;

public interface OrderItemService {
    OrderItemDTO save (OrderItemDTO dto);
    OrderItemDTO findById(Long id);
    List<OrderItemDTO> getAll();
    OrderItemDTO update(Long id, OrderItemDTO dto);
    void deleteById(Long id);
}
