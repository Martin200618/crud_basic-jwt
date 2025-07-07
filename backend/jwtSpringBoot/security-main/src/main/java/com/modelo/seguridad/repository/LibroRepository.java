package com.modelo.seguridad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.modelo.seguridad.model.libro;

public interface LibroRepository extends JpaRepository<libro, Long> {
}