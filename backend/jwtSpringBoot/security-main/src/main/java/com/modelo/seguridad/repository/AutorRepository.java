package com.modelo.seguridad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.modelo.seguridad.model.autor;

public interface AutorRepository extends JpaRepository<autor, Long> {
    // Métodos personalizados si los necesitas
}