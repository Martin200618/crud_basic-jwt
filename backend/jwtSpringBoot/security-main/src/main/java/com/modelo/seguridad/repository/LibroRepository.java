package com.modelo.seguridad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.modelo.seguridad.model.Libros;

public interface LibroRepository extends JpaRepository<Libros, Long> {
}