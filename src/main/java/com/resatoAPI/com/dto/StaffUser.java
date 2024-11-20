package com.resatoAPI.com.dto;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StaffUser {
        private Long id;
        private String email;
        private long contact;
        private String login;
        private String password;

}
