package com.resatoAPI.com.dto;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StaffUserDTO {
        private Long id;
        private String email;
        private long contact;
        private String login;
        private String password;

}
