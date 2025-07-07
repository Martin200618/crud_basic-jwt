package com.modelo.seguridad.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.modelo.seguridad.DTO.LibroAutorDTO;
import com.modelo.seguridad.model.LibroAutor;
import com.modelo.seguridad.service.LibroAutorService;

@RestController
@RequestMapping("/api/libros-autores")
public class LibroAutorController {

    @Autowired
    private LibroAutorService libroAutorService;

    @GetMapping
    public List<LibroAutor> getAll() {
        return libroAutorService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<LibroAutor> getById(@PathVariable Long id) {
        return libroAutorService.findById(id);
    }

    @PostMapping
    public String create(@RequestBody LibroAutorDTO dto) {
        return libroAutorService.save(dto);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody LibroAutorDTO dto) {
        return libroAutorService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return libroAutorService.delete(id);
    }
}