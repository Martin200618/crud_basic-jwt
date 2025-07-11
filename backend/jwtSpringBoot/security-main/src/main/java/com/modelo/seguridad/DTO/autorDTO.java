package com.modelo.seguridad.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class autorDTO {
    private Long id;
    private String nombre;
    private String nacionalidad;
    private String fechaNacimiento; // en formato "yyyy-MM-dd"

    // Getters y Setters
}