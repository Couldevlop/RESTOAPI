package com.resatoAPI.com.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.resatoAPI.com.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
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
    @DateTimeFormat(pattern = "yyyy-MM-dd") // Utilisé pour les formulaires web Spring
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") // Pour la sérialisation/désérialisation JSON
    private LocalDate orderDate;
}
