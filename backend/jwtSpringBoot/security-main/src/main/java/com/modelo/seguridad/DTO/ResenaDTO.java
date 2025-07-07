package com.modelo.seguridad.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResenaDTO {
    private Long id;
    private Long usuarioId;
    private Long libroId;
    private String comentario;
    private int calificacion;
    private String fecha; // formato: "yyyy-MM-dd"

    // Getters y Setters
}
