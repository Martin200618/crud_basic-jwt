package com.modelo.seguridad.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class libroDTO {
    private Long id;
    private String titulo;
    private String autor;
    private int añoPublicacion;
    private String genero;
    private String isbn;
    private boolean disponible;
    // Getters y Setters
}