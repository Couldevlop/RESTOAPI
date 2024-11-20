package com.resatoAPI.com.dto;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientUser {
    public class User {
        private Long id;
        private String email;
        private long contact;
    }
}
