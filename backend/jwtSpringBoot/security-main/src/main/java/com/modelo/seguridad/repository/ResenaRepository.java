package com.modelo.seguridad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.modelo.seguridad.DTO.ResenaDTO;
import com.modelo.seguridad.model.Reseña;

public interface ResenaRepository extends JpaRepository<Reseña, Long> {
    String save(ResenaDTO dto);
    String update(Long id, ResenaDTO dto);
    String delete(Long id);
}