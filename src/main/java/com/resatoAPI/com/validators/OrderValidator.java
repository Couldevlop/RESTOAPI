package com.resatoAPI.com.validators;

import com.resatoAPI.com.dto.OrderDTO;
import com.resatoAPI.com.entity.Order;
import com.resatoAPI.com.exception.OrderItemNotFoundException;
import com.resatoAPI.com.exception.OrderNullException;
import com.resatoAPI.com.repository.OrderRepository;
import org.springframework.stereotype.Component;

@Component
public class OrderValidator {

    private final OrderRepository orderRepository;

    public OrderValidator(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void validateOrderDTO(OrderDTO dto){
        if(dto == null){
            throw new OrderNullException("The object provided is null: {}");
        }
    }

    public void validateId(Long id){
        if(id == null){
            throw new OrderNullException("The ID provided is null");
        }
    }

    public Order findOrderOrThrow(Long id){
        return  orderRepository.findById(id).orElseThrow(() ->
                new OrderItemNotFoundException("The order with ID " + id + " not found in DB"));

    }

    public void validateUpdateRequest(Long id, OrderDTO dto){
        validateId(id);
        validateOrderDTO(dto);
    }
}
