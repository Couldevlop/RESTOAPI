package com.resatoAPI.com.validators;

import com.resatoAPI.com.dto.OrderItemDTO;
import com.resatoAPI.com.entity.OrderItem;
import com.resatoAPI.com.exception.OrderItemAlReadyExistException;
import com.resatoAPI.com.exception.OrderItemNotFoundException;
import com.resatoAPI.com.exception.OrderItemNullException;
import com.resatoAPI.com.repository.OrderItemRepository;
import org.springframework.stereotype.Component;

@Component
public class OrderItemValidator {

    private final OrderItemRepository orderItemRepository;

    public OrderItemValidator(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public void validateOrderItemDTO(OrderItemDTO dto){
        if(dto == null){
            throw new OrderItemNullException("The object provided is null");
        }
    }

    public void validateId(Long id){
        if(id == null){
            throw  new OrderItemNullException("The ID provided is null");
        }
    }

    public void checkIfOrderItemExists(String name){
        if(orderItemRepository.findByName(name)){
            throw new OrderItemAlReadyExistException("The OrderItem already exists ");
        }
    }

    public OrderItem findOrderItemOrThrow(Long id){
        return orderItemRepository.findById(id).orElseThrow(()->
                new OrderItemNotFoundException("The OrderItem with ID " + id + "not found in DB"));
    }

    public void validateUpdateRequest(Long id, OrderItemDTO dto){
        validateId(id);
        validateOrderItemDTO(dto);
    }
}
