package com.resatoAPI.com.dto;

import com.resatoAPI.com.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.util.List;
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long id;
    private String tableNumber;
    private List<OrderItemDTO> items;
    @Enumerated(EnumType.STRING)
    private Status status;
}
