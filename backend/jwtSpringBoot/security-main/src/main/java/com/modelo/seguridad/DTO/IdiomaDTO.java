package com.modelo.seguridad.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdiomaDTO {

    private Long id;
    private String nombre;
    private String codigoIso;

    // Getters y Setters
}