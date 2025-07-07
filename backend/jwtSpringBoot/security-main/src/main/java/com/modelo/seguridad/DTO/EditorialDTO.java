package com.modelo.seguridad.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditorialDTO {
    private Long id;
    private String nombre;
    private String pais;
    private int anioFundacion;

    // Getters and Setters
}
