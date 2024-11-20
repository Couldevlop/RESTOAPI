package com.resatoAPI.com.entity;

import com.resatoAPI.com.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.util.List;

@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long id;
    private String tableNumber;
    private List<OrderItem> items;
    @Enumerated(EnumType.STRING)
    private Status status;
}
