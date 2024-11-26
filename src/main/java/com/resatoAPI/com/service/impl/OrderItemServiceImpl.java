package com.resatoAPI.com.service.impl;

import com.resatoAPI.com.dto.OrderItemDTO;
import com.resatoAPI.com.entity.OrderItem;
import com.resatoAPI.com.mapper.ObjectMapper;
import com.resatoAPI.com.repository.OrderItemRepository;
import com.resatoAPI.com.service.OrderItemService;
import com.resatoAPI.com.validators.OrderItemValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemRepository orderItemRepository;
    private final OrderItemValidator orderItemValidator;
    private final ObjectMapper mapper;

    public OrderItemServiceImpl(OrderItemRepository orderItemRepository, OrderItemValidator orderItemValidator, ObjectMapper mapper) {
        this.orderItemRepository = orderItemRepository;
        this.orderItemValidator = orderItemValidator;
        this.mapper = mapper;
    }

    @Override
    public OrderItemDTO save(OrderItemDTO dto) {
        orderItemValidator.validateOrderItemDTO(dto);
        OrderItem orderItem = mapper.dtoToOrderItem(dto);
        OrderItem orderItemSaved = orderItemRepository.save(orderItem);
        return mapper.orderItemToDTO(orderItemSaved);
    }

    @Override
    public OrderItemDTO findById(Long id) {
        orderItemValidator.validateId(id);
        OrderItem existingOrderItem = orderItemValidator.findOrderItemOrThrow(id);
        return mapper.orderItemToDTO(existingOrderItem);
    }

    @Override
    public List<OrderItemDTO> getAll() {
        return orderItemRepository.findAll().stream().map(mapper::orderItemToDTO).collect(Collectors.toList());
    }

    @Override
    public OrderItemDTO update(Long id, OrderItemDTO dto) {
        orderItemValidator.validateUpdateRequest(id, dto);
        OrderItem existingOrderItem = orderItemValidator.findOrderItemOrThrow(id);
        existingOrderItem.setOrderType(dto.getOrderType());
        existingOrderItem.setName(dto.getName());
        existingOrderItem.setPrice(dto.getPrice());
        existingOrderItem.setImage(dto.getImage());
        existingOrderItem.setQuantity(dto.getQuantity());
        OrderItem orderItemSaved = orderItemRepository.save(existingOrderItem);
        return mapper.orderItemToDTO(orderItemSaved);
    }

    @Override
    public void deleteById(Long id) {
        orderItemValidator.validateId(id);
        orderItemValidator.findOrderItemOrThrow(id);
        orderItemRepository.deleteById(id);

    }
}
