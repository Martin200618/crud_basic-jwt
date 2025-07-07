package com.modelo.seguridad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.modelo.seguridad.model.LibroAutor;

public interface LibroAutorRepository extends JpaRepository<LibroAutor, Long> {
}