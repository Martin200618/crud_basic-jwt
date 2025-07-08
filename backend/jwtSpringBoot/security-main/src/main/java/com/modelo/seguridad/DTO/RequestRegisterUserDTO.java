package com.modelo.seguridad.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestRegisterUserDTO {
    private String username;
    private String password;
    private String email;

    // Getters and Setters
}