package com.resatoAPI.com.dto;

import lombok.*;

import java.util.List;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryWithDishesDTO {
    private Long id;
    private String name;
    private List<DishDTO> dishes;
}
