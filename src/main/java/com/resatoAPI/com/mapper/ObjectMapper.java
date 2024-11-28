package com.resatoAPI.com.mapper;

import com.resatoAPI.com.dto.*;
import com.resatoAPI.com.entity.Category;
import com.resatoAPI.com.entity.Dish;
import com.resatoAPI.com.entity.Order;
import com.resatoAPI.com.entity.OrderItem;
import com.resatoAPI.com.enums.Status;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.stream.Collectors;

@Component
public class ObjectMapper {

   /*public CategoryDTO categoryToDTO(Category category){
         return CategoryDTO.builder()
                 .id(category.getId())
                 .name(category.getName())
                 .dishes(category.getDishes() != null ? category.getDishes().stream().map(this::dishToDTO ).collect(Collectors.toList()) : null)
                 .build();
    }*/

    public CategoryDTO categoryToDTO(Category category){
         return CategoryDTO.builder()
                 .id(category.getId())
                 .name(category.getName())
                 .build();
    }

    /*public Category dtoToCategory(CategoryDTO dto){
        return Category.builder()
                .id(dto.getId())
                .name(dto.getName())
                .dishes(dto.getDishes() != null ? dto.getDishes().stream().map(this::dtoToDish).collect(Collectors.toList()) : null)
                .build();
    }*/



    public Category dtoToCategory(CategoryDTO dto){
        return Category.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }

    // Convertit un Dish en DishDTO
   public DishDTO dishToDTO(Dish dish){
         return DishDTO.builder()
                 .id(dish.getId())
                 .price(dish.getPrice())
                 .image(dish.getImage())
                 .description(dish.getDescription())
                 .ingredients(dish.getIngredients())
                 .categoryId(dish.getCategory() !=null ? dish.getCategory().getId(): null)
                 .build();    }




    public Dish dtoToDish(DishDTO dto) {
        return Dish.builder()
                .price(dto.getPrice())
                .name(dto.getName())
                .image(dto.getImage())
                .ingredients(dto.getIngredients()) // Fixed typo
                .description(dto.getDescription())
                .category(dto.getCategoryId() != null ?
                        Category.builder()
                                .id(dto.getCategoryId()) // Corrected to use getCategoryId()
                                .build()
                        : null)
                .build();
    }


    // Convertit une entité Category en CategoryWithDishesDTO
    public CategoryWithDishesDTO categoryToWithDishesDTO(Category category) {
        return CategoryWithDishesDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .dishes(
                        category.getDishes() != null
                                ? category.getDishes().stream()
                                .map(this::dishToDTO)
                                .collect(Collectors.toList())
                                : null
                )
                .build();
    }


    public OrderDTO orderToDTO(Order order) {
         return OrderDTO.builder()
                 .id(order.getId())
                 .tableNumber(order.getTableNumber())
                 .items(order.getItems() !=null ?
                         order.getItems().stream().map(this::orderItemToDTO).collect(Collectors.toList()) : null)
                 .status(order.getStatus() != null ? order.getStatus() : Status.EN_ATTENTE)
                 .build();
    }

    public Order dtoToOrder(OrderDTO dto){
        return Order.builder()
                .tableNumber(dto.getTableNumber())
                .status(dto.getStatus())
                .items(dto.getItems() != null ? dto.getItems().stream().map(this::dtoToOrderItem).collect(Collectors.toList()) : null)
                .build();
    }

    public OrderItemDTO orderItemToDTO(OrderItem orderItem){
         return OrderItemDTO.builder()
                 .id(orderItem.getId())
                 .image(orderItem.getImage())
                 .name(orderItem.getName())
                 .orderType(orderItem.getOrderType())
                 .price(orderItem.getPrice())
                 .build();
    }


    public OrderItem dtoToOrderItem(OrderItemDTO dto){
       return OrderItem.builder()
               .id(dto.getId())
               .image(dto.getImage())
               .name(dto.getName())
               .orderType(dto.getOrderType())
               .price(dto.getPrice())
               .quantity(dto.getQuantity())
               .build();
    }
}
