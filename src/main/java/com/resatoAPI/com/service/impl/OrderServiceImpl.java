package com.resatoAPI.com.service.impl;

import com.resatoAPI.com.dto.OrderDTO;
import com.resatoAPI.com.entity.Order;
import com.resatoAPI.com.entity.OrderItem;
import com.resatoAPI.com.enums.Status;
import com.resatoAPI.com.mapper.ObjectMapper;
import com.resatoAPI.com.repository.OrderItemRepository;
import com.resatoAPI.com.repository.OrderRepository;
import com.resatoAPI.com.service.OrderService;
import com.resatoAPI.com.validators.OrderValidator;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderValidator orderValidator;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final ObjectMapper mapper;

    public OrderServiceImpl(OrderValidator orderValidator, OrderRepository orderRepository, OrderItemRepository orderItemRepository, ObjectMapper mapper) {
        this.orderValidator = orderValidator;
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.mapper = mapper;
    }

   /* @Override
    public OrderDTO save(OrderDTO dto) {
        orderValidator.validateOrderDTO(dto);
        Order order = mapper.dtoToOrder(dto);
        Order orderSaved = orderRepository.save(order);
        return mapper.orderToDTO(orderSaved);
    }*/

    @Override
    public OrderDTO save(OrderDTO dto) {
        // Mapper le DTO vers l’entité Order
        Order order = new Order();
        order.setTableNumber(dto.getTableNumber());
        order.setStatus(dto.getStatus());

        // Associer les OrderItem existants au nouvel Order
        if (dto.getItems() != null && !dto.getItems().isEmpty()) {
            List<OrderItem> items = dto.getItems().stream()
                    .map(item -> orderItemRepository.findById(item.getId())
                            .orElseThrow(() -> new IllegalArgumentException("OrderItem not found with ID: " +  item.getId())))
                    .collect(Collectors.toList());
            items.forEach(item -> item.setOrder(order)); // Associer chaque item à l’Order
            order.setItems(items);
        }

        // Sauvegarder l’Order (et les associations via CascadeType.ALL)
        Order savedOrder = orderRepository.save(order);

        return mapper.orderToDTO(savedOrder);
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
    @Transactional
    public OrderDTO update(Long id, OrderDTO dto) {
        // Valider la requête de mise à jour
        orderValidator.validateUpdateRequest(id, dto);

        // Trouver l'Order existant
        Order existingOrder = orderValidator.findOrderOrThrow(id);

        // Mettre à jour les champs simples
        existingOrder.setTableNumber(dto.getTableNumber());
        existingOrder.setStatus(dto.getStatus());

        // Convertir les items du DTO en une liste d'entités OrderItem
        List<OrderItem> incomingItems = mapper.dtoToOrder(dto).getItems();

        if (incomingItems != null) {
            // Récupérer les IDs des nouveaux items
            List<Long> incomingItemIds = incomingItems.stream()
                    .map(OrderItem::getId)
                    .filter(Objects::nonNull) // Ignorer les nouveaux items (ID null)
                    .toList();

            // Identifier les items à supprimer
            List<OrderItem> itemsToRemove = existingOrder.getItems().stream()
                    .filter(item -> !incomingItemIds.contains(item.getId())) // Items non présents dans la nouvelle liste
                    .toList();

            // Supprimer les items obsolètes
            itemsToRemove.forEach(item -> item.setOrder(null)); // Détacher avant suppression
            existingOrder.getItems().removeAll(itemsToRemove);

            // Ajouter ou mettre à jour les items restants
            for (OrderItem incomingItem : incomingItems) {
                if (incomingItem.getId() != null) {
                    // Trouver et mettre à jour l'item existant
                    OrderItem existingItem = existingOrder.getItems().stream()
                            .filter(item -> item.getId().equals(incomingItem.getId()))
                            .findFirst()
                            .orElseThrow(() -> new IllegalArgumentException("OrderItem not found: " + incomingItem.getId()));

                    // Mettre à jour les champs de l'item existant
                    existingItem.setName(incomingItem.getName());
                    existingItem.setPrice(incomingItem.getPrice());
                    existingItem.setQuantity(incomingItem.getQuantity());
                    existingItem.setImage(incomingItem.getImage());
                    existingItem.setOrderType(incomingItem.getOrderType());
                } else {
                    // Ajouter un nouvel item
                    incomingItem.setOrder(existingOrder); // Associer au parent
                    existingOrder.getItems().add(incomingItem);
                }
            }
        }

        // Sauvegarder l'Order avec ses items mis à jour
        Order updatedOrder = orderRepository.save(existingOrder);

        // Retourner le DTO de l'Order mis à jour
        return mapper.orderToDTO(updatedOrder);
    }

    @Override
    public void deleteById(Long id) {
        orderValidator.validateId(id);
        orderValidator.findOrderOrThrow(id);
        orderRepository.deleteById(id);

    }

    @Override
    public double getTotalForServedOrders() {
        // Récupère toutes les commandes avec le statut SERVI et calcule leur somme
        return orderRepository.findAllByStatus(Status.SERVI).stream()
                .flatMap(order -> order.getItems().stream()) // Accède aux items de chaque commande
                .mapToDouble(item -> item.getPrice() * item.getQuantity()) // Calcule le total pour chaque item
                .sum();
    }
}
