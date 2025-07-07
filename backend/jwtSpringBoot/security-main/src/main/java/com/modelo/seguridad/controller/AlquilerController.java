package com.modelo.seguridad.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.modelo.seguridad.DTO.AlquilerDTO;
import com.modelo.seguridad.model.Alquileres;
import com.modelo.seguridad.service.AlquilerService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/alquileres")
public class AlquilerController {

    @Autowired 
    private AlquilerService alquilerService;

    @GetMapping
    public List<Alquileres> getAll() {
        return alquilerService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Alquileres> getById(@PathVariable Long id) {
        return alquilerService.findById(id);
    }

    @PostMapping
    public String create(@RequestBody AlquilerDTO dto) {
        return alquilerService.save(dto);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody AlquilerDTO dto) {
        return alquilerService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return alquilerService.delete(id);
    }
}