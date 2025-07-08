package com.modelo.seguridad.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestLoginDTO {
    private String username;
    private String password;

    //Getters and Setters
}