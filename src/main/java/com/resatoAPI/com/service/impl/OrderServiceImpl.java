package com.resatoAPI.com.service.impl;

import com.resatoAPI.com.dto.OrderDTO;
import com.resatoAPI.com.entity.Order;
import com.resatoAPI.com.entity.OrderItem;
import com.resatoAPI.com.mapper.ObjectMapper;
import com.resatoAPI.com.repository.OrderRepository;
import com.resatoAPI.com.service.OrderService;
import com.resatoAPI.com.validators.OrderValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderValidator orderValidator;
    private final OrderRepository orderRepository;
    private final ObjectMapper mapper;

    public OrderServiceImpl(OrderValidator orderValidator, OrderRepository orderRepository, ObjectMapper mapper) {
        this.orderValidator = orderValidator;
        this.orderRepository = orderRepository;
        this.mapper = mapper;
    }

    @Override
    public OrderDTO save(OrderDTO dto) {
        orderValidator.validateOrderDTO(dto);
        Order order = mapper.dtoToOrder(dto);
        Order orderSaved = orderRepository.save(order);
        return mapper.orderToDTO(orderSaved);
    }

    @Override
    public OrderDTO findById(Long id) {
        orderValidator.validateId(id);
        Order existingOrder = orderValidator.findOrderOrThrow(id);
        return mapper.orderToDTO(existingOrder);
    }

    @Override
    public List<OrderDTO> getAll() {
        return orderRepository.findAll().stream().map(mapper::orderToDTO).collect(Collectors.toList());
    }

    @Override
    public OrderDTO update(Long id, OrderDTO dto) {
        orderValidator.validateUpdateRequest(id, dto);
        Order existOrder = orderValidator.findOrderOrThrow(id);
        existOrder.setStatus(dto.getStatus());
        existOrder.setTableNumber(dto.getTableNumber());
        if(dto.getItems() != null){
            existOrder.getItems().clear();
            dto.getItems().forEach(orderItemDTO -> {
                OrderItem orderItem = mapper.dtoToOrderItem(orderItemDTO);
                orderItem.setOrderId(id);
                orderItem.setQuantity(orderItemDTO.getQuantity());
                orderItem.setName(orderItem.getName());
                orderItem.setImage(orderItem.getImage());
                orderItem.setPrice(orderItem.getOrderId());
                orderItem.setOrderType(orderItem.getOrderType());
                existOrder.getItems().add(orderItem);
            });

            Order orderUpdate = orderRepository.save(existOrder);

        }
        return mapper.orderToDTO(existOrder);
    }

    @Override
    public void deleteById(Long id) {
        orderValidator.validateId(id);
        orderValidator.findOrderOrThrow(id);
        orderRepository.deleteById(id);

    }
}
