package com.modelo.seguridad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.modelo.seguridad.model.Editoriales;

public interface EditorialRepository extends JpaRepository<Editoriales, Long> {
}