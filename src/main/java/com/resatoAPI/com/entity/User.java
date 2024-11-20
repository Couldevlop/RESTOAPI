package com.resatoAPI.com.entity;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String email;
    private long contact;
    private String login;
    private String password;
}
