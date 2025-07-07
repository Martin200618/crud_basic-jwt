package com.modelo.seguridad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.modelo.seguridad.model.Autores;

public interface AutorRepository extends JpaRepository<Autores, Long> {
    // Métodos personalizados si los necesitas
}