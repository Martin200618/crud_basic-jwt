package com.modelo.seguridad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.modelo.seguridad.model.Alquileres;

public interface AlquilerRepository extends JpaRepository<Alquileres, Long> {
}