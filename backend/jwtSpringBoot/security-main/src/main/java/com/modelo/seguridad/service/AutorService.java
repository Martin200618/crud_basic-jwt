package com.modelo.seguridad.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.modelo.seguridad.DTO.autorDTO;
import com.modelo.seguridad.model.Autores;
import com.modelo.seguridad.repository.AutorRepository;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    // Obtener todos los autores
    public List<Autores> findAll() {
        return autorRepository.findAll();
    }

    // Obtener autor por ID
    public Optional<Autores> findById(Long id) {
        return autorRepository.findById(id);
    }

    // Registrar un autor
    public String save(autorDTO dto) {
        Autores autor = convertToModel(dto);
        autorRepository.save(autor);
        return HttpStatus.OK.toString() + ": Autor registrado exitosamente";
    }

    // Actualizar un autor
    public String update(Long id, autorDTO dto) {
        Optional<Autores> existing = findById(id);
        if (existing.isEmpty()) {
            return HttpStatus.BAD_REQUEST.toString() + ": El autor no existe";
        }

        Autores autorToUpdate = updateFields(existing.get(), dto);
        autorRepository.save(autorToUpdate);
        return HttpStatus.OK.toString() + ": Autor actualizado correctamente";
    }

    // Eliminar autor por ID
    public String delete(Long id) {
        Optional<Autores> autor = findById(id);
        if (autor.isEmpty()) {
            return HttpStatus.BAD_REQUEST.toString() + ": El autor no existe o ya fue eliminado";
        }

        autorRepository.deleteById(id);
        return HttpStatus.OK.toString() + ": Autor eliminado correctamente";
    }

    // Conversión de DTO a modelo
    private Autores convertToModel(autorDTO dto) {
        try {
            java.util.Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(dto.getFechaNacimiento());
            Autores autor = new Autores();
            autor.setNombre(dto.getNombre());
            autor.setNacionalidad(dto.getNacionalidad());
            autor.setFechaNacimiento(new java.sql.Date(fecha.getTime()));
            return autor;
        } catch (ParseException e) {
            throw new RuntimeException("Formato de fecha inválido: " + dto.getFechaNacimiento(), e);
        }
    }

    // Método para actualizar campos
    private Autores updateFields(Autores autor, autorDTO dto) {
        try {
            java.util.Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(dto.getFechaNacimiento());
            autor.setNombre(dto.getNombre());
            autor.setNacionalidad(dto.getNacionalidad());
            autor.setFechaNacimiento(new java.sql.Date(fecha.getTime()));
            return autor;
        } catch (ParseException e) {
            throw new RuntimeException("Formato de fecha inválido: " + dto.getFechaNacimiento(), e);
        }
    }
}