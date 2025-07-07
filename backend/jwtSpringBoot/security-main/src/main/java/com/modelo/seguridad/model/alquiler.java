package com.modelo.seguridad.model;

import java.time.LocalDate;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "alquiler")
public class alquiler {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne 
    private User user;
    @ManyToOne 
    private libro libros;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String estado;
    // Getters y setters
}