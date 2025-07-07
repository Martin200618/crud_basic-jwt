package com.modelo.seguridad.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.modelo.seguridad.DTO.libroDTO;
import com.modelo.seguridad.model.libro;
import com.modelo.seguridad.repository.LibroRepository;

@Service
public class libroService {

    @Autowired
    private LibroRepository libroRepository;

    // Obtener todos los libros
    public List<libro> findAll() {
        return libroRepository.findAll();
    }

    // Obtener libro por ID
    public Optional<libro> findById(Long id) {
        return libroRepository.findById(id);
    }

    // Registrar un libro
    public String save(libroDTO dto) {
        libro libro = convertToModel(dto);
        libroRepository.save(libro);
        return HttpStatus.OK.toString() + ": Libro registrado exitosamente";
    }

    // Actualizar un libro
    public String update(Long id, libroDTO dto) {
        Optional<libro> existing = findById(id);
        if (existing.isEmpty()) {
            return HttpStatus.BAD_REQUEST.toString() + ": El libro no existe";
        }

        libro libroToUpdate = updateFields(existing.get(), dto);
        libroRepository.save(libroToUpdate);
        return HttpStatus.OK.toString() + ": Libro actualizado correctamente";
    }

    // Eliminar libro por ID
    public String delete(Long id) {
        Optional<libro> libro = findById(id);
        if (libro.isEmpty()) {
            return HttpStatus.BAD_REQUEST.toString() + ": El libro no existe o ya fue eliminado";
        }

        libroRepository.deleteById(id);
        return HttpStatus.OK.toString() + ": Libro eliminado correctamente";
    }

    // Conversión de DTO a Modelo
    private libro convertToModel(libroDTO dto) {
        libro libro = new libro();
        libro.setTitulo(dto.getTitulo());
        libro.setAutor(dto.getAutor());
        libro.setAñoPublicacion(dto.getAñoPublicacion());
        libro.setGenero(dto.getGenero());
        libro.setIsbn(dto.getIsbn());
        libro.setDisponible(dto.isDisponible());
        return libro;
    }

    // Método para actualizar los campos de un libro existente
    private libro updateFields(libro libro, libroDTO dto) {
        libro.setTitulo(dto.getTitulo());
        libro.setAutor(dto.getAutor());
        libro.setAñoPublicacion(dto.getAñoPublicacion());
        libro.setGenero(dto.getGenero());
        libro.setIsbn(dto.getIsbn());
        libro.setDisponible(dto.isDisponible());
        return libro;
    }
}