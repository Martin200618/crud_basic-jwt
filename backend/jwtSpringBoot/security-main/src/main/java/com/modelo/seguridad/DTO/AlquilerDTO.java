package com.modelo.seguridad.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlquilerDTO {
    private Long id;
    private Long usuarioId;
    private Long libroId;
    private String fechaAlquiler;
    private String fechaDevolucion;

    // Getters y Setters
}
