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

import com.modelo.seguridad.DTO.ResenaDTO;
import com.modelo.seguridad.model.Reseña;
import com.modelo.seguridad.service.ResenaService;

@RestController
@RequestMapping("/api/resenas")
public class ResenaController {

    @Autowired
    private ResenaService resenaService;

    @GetMapping
    public List<Reseña> getAll() {
        return resenaService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Reseña> getById(@PathVariable Long id) {
        return resenaService.findById(id);
    }

    @PostMapping
    public String create(@RequestBody ResenaDTO dto) {
        return resenaService.create(dto);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody ResenaDTO dto) {
        return resenaService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return resenaService.delete(id);
    }
}