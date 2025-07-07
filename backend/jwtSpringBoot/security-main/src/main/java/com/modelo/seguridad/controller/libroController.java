package com.modelo.seguridad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import com.modelo.seguridad.DTO.libroDTO;
import com.modelo.seguridad.model.libro;
import com.modelo.seguridad.service.libroService;
@RestController
@RequestMapping("/api/libros")
public class libroController {

    @Autowired
    private libroService libroService;

    // Obtener todos los libros
    @GetMapping
    public List<libro> getAll() {
        return libroService.findAll();
    }

    // Obtener un libro por ID
    @GetMapping("/{id}")
    public Optional<libro> getById(@PathVariable Long id) {
        return libroService.findById(id);
    }

    // Registrar un nuevo libro
    @PostMapping
    public String create(@RequestBody libroDTO libroDTO) {
        return libroService.save(libroDTO);
    }

    // Actualizar un libro existente
    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody libroDTO libroDTO) {
        return libroService.update(id, libroDTO);
    }

    // Eliminar un libro por ID
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return libroService.delete(id);
    }
}