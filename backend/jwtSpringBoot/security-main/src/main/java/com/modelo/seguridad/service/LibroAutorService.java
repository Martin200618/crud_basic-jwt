package com.modelo.seguridad.service;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.modelo.seguridad.DTO.LibroAutorDTO;
import com.modelo.seguridad.model.LibroAutor;
import com.modelo.seguridad.model.Libros;
import com.modelo.seguridad.model.Autores;
import com.modelo.seguridad.repository.AutorRepository;
import com.modelo.seguridad.repository.LibroAutorRepository;
import com.modelo.seguridad.repository.LibroRepository;

@Service
public class LibroAutorService {

    private LibroAutorRepository libroAutorRepository;

    private LibroRepository libroRepository;

    private AutorRepository autorRepository;

    public List<LibroAutor> findAll() {
        return libroAutorRepository.findAll();
    }

    public Optional<LibroAutor> findById(Long id) {
        return libroAutorRepository.findById(id);
    }

    public String save(LibroAutorDTO dto) {
        Optional<Libros> libro = libroRepository.findById(dto.getLibroId());
        Optional<Autores> autor = autorRepository.findById(dto.getAutorId());

        if (libro.isEmpty()) return HttpStatus.BAD_REQUEST + ": Libro no encontrado";
        if (autor.isEmpty()) return HttpStatus.BAD_REQUEST + ": Autor no encontrado";

        LibroAutor la = new LibroAutor();
        la.setLibro(libro.get());
        la.setAutores(autor.get());
        libroAutorRepository.save(la);
        return HttpStatus.OK + ": Relación Libro-Autor registrada correctamente";
    }

    public String update(Long id, LibroAutorDTO dto) {
        Optional<LibroAutor> existente = libroAutorRepository.findById(id);
        if (existente.isEmpty()) return HttpStatus.BAD_REQUEST + ": Relación no encontrada";

        Optional<Libros> libro = libroRepository.findById(dto.getLibroId());
        Optional<Autores> autor = autorRepository.findById(dto.getAutorId());

        if (libro.isEmpty()) return HttpStatus.BAD_REQUEST + ": Libro no encontrado";
        if (autor.isEmpty()) return HttpStatus.BAD_REQUEST + ": Autor no encontrado";

        LibroAutor la = existente.get();
        la.setLibro(libro.get());
        la.setAutores(autor.get());
        libroAutorRepository.save(la);
        return HttpStatus.OK + ": Relación actualizada correctamente";
    }

    public String delete(Long id) {
        if (!libroAutorRepository.existsById(id)) {
            return HttpStatus.BAD_REQUEST + ": Relación no encontrada o ya eliminada";
        }
        libroAutorRepository.deleteById(id);
        return HttpStatus.OK + ": Relación eliminada correctamente";
    }
}