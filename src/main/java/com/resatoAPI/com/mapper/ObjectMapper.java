package com.resatoAPI.com.mapper;

import com.resatoAPI.com.dto.CategoryDTO;
import com.resatoAPI.com.dto.DishDTO;
import com.resatoAPI.com.dto.OrderDTO;
import com.resatoAPI.com.dto.OrderItemDTO;
import com.resatoAPI.com.entity.Category;
import com.resatoAPI.com.entity.Dish;
import com.resatoAPI.com.entity.Order;
import com.resatoAPI.com.entity.OrderItem;
import com.resatoAPI.com.enums.Status;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.stream.Collectors;

@Component
public class ObjectMapper {

   public CategoryDTO categoryToDTO(Category category){
         return CategoryDTO.builder()
                 .id(category.getId())
                 .name(category.getName())
                 .dishes(category.getDishes() != null ? category.getDishes().stream().map(this::dishToDTO ).collect(Collectors.toList()) : null)
                 .build();
    }

    public Category dtoToCategory(CategoryDTO dto){
        return Category.builder()
                .id(dto.getId())
                .name(dto.getName())
                .dishes(dto.getDishes() != null ? dto.getDishes().stream().map(this::dtoToDish).collect(Collectors.toList()) : null)
                .build();
    }


   public DishDTO dishToDTO(Dish dish){
         return DishDTO.builder()
                 .id(dish.getId())
                 .price(dish.getPrice())
                 .image(dish.getImage())
                 .description(dish.getDescription())
                 .ingerdients(dish.getIngerdients())
                 .categoryId(dish.getId())
                 .build();    }

   public Dish dtoToDish(DishDTO dto){
        return Dish.builder()
                .price(dto.getPrice())
                .image(dto.getImage())
                .ingerdients(dto.getIngerdients())
                .description(dto.getDescription())
                .category(dto.getCategoryId() != null ? Category.builder() .id(dto.getId()).build() : null)
                .build();
   }


    public OrderDTO OrderToDTO(Order order) {
         return OrderDTO.builder()
                 .id(order.getId())
                 .tableNumber(order.getTableNumber())
                 .items(order.getItems() !=null ?
                         order.getItems().stream().map(this::orderItemToDTO).collect(Collectors.toList()) : null)
                 .status(order.getStatus() != null ? order.getStatus() : Status.EN_ATTENTE)
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
}
