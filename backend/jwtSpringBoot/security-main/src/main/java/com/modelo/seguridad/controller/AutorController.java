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
import com.modelo.seguridad.DTO.autorDTO;
import com.modelo.seguridad.model.autor;
import com.modelo.seguridad.service.AutorService;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public List<autor> getAll() {
        return autorService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<autor> getById(@PathVariable Long id) {
        return autorService.findById(id);
    }

    @PostMapping
    public String create(@RequestBody autorDTO dto) {
        return autorService.save(dto);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody autorDTO dto) {
        return autorService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return autorService.delete(id);
    }
}