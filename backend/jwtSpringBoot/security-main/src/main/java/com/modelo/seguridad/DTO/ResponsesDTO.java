package com.modelo.seguridad.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponsesDTO {
    private String status;
    private String message;

    // Getters and Setters
}