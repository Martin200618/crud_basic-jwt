package com.modelo.seguridad.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibroAutorDTO {
    private Long id;
    private Long libroId;
    private Long autorId;

    // Getters y Setters
}