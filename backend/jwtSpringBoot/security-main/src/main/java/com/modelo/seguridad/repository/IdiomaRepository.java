package com.modelo.seguridad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.modelo.seguridad.model.idioma;

public interface IdiomaRepository extends JpaRepository<idioma, Long> {
    // Métodos personalizados si los necesitas
}