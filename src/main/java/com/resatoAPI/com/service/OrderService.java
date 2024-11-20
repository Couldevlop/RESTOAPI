package com.resatoAPI.com.service;

import com.resatoAPI.com.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    OrderDTO save (OrderDTO dto);
    OrderDTO findById(Long id);
    List<OrderDTO> getAll();
    OrderDTO update(Long id, OrderDTO dto);
    void deleteById(Long id);
}
