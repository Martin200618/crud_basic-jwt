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
import com.modelo.seguridad.DTO.IdiomaDTO;
import com.modelo.seguridad.model.idioma;
import com.modelo.seguridad.service.IdiomaService;

@RestController
@RequestMapping("/api/idiomas")
public class IdiomaController {

    @Autowired
    private IdiomaService idiomaService;

    @GetMapping
    public List<idioma> getAll() {
        return idiomaService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<idioma> getById(@PathVariable Long id) {
        return idiomaService.findById(id);
    }

    @PostMapping
    public String create(@RequestBody IdiomaDTO dto) {
        return idiomaService.save(dto);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody IdiomaDTO dto) {
        return idiomaService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return idiomaService.delete(id);
    }
}