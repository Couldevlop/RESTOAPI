package com.resatoAPI.com.dto;

import com.resatoAPI.com.entity.Category;
import jakarta.persistence.*;
import lombok.*;


@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DishDTO {
    private Long id;
    private String name;
    private String description;
    private String ingerdients;
    private double price;
    private String image;
    private Long categoryId;
}
