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

import com.modelo.seguridad.DTO.EditorialDTO;
import com.modelo.seguridad.model.Editoriales;
import com.modelo.seguridad.service.EditorialService;

@RestController
@RequestMapping("/api/editoriales")
public class EditorialController {

    @Autowired
    private EditorialService editorialService;

    @GetMapping
    public List<Editoriales> getAll() {
        return editorialService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Editoriales> getById(@PathVariable Long id) {
        return editorialService.findById(id);
    }

    @PostMapping
    public String create(@RequestBody EditorialDTO dto) {
        return editorialService.save(dto);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody EditorialDTO dto) {
        return editorialService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return editorialService.delete(id);
    }
}