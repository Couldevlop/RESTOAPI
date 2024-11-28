package com.resatoAPI.com.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "resto_dish")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String ingredients;
    private double price;
    private String image;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
