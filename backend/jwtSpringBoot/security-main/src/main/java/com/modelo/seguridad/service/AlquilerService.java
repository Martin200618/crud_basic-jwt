package com.modelo.seguridad.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.modelo.seguridad.DTO.AlquilerDTO;
import com.modelo.seguridad.model.Users;
import com.modelo.seguridad.model.Alquileres;
import com.modelo.seguridad.model.Libros;
import com.modelo.seguridad.repository.AlquilerRepository;
import com.modelo.seguridad.repository.Iuser;
import com.modelo.seguridad.repository.LibroRepository;

@Service
public class AlquilerService {

    @Autowired
    private AlquilerRepository alquilerRepository;

    @Autowired
    private Iuser usuarioRepository;

    @Autowired
    private LibroRepository libroRepository;

    public List<Alquileres> findAll() {
        return alquilerRepository.findAll();
    }

    public Optional<Alquileres> findById(Long id) {
        return alquilerRepository.findById(id);
    }

    public String save(AlquilerDTO dto) {
        Optional<Users> usuario = usuarioRepository.findById(dto.getUsuarioId().intValue());
        Optional<Libros> libro = libroRepository.findById(dto.getLibroId());

        if (usuario.isEmpty()) return HttpStatus.BAD_REQUEST + ": Usuario no encontrado";
        if (libro.isEmpty()) return HttpStatus.BAD_REQUEST + ": Libro no encontrado";

        Alquileres alquiler = convertToModel(dto, usuario.get(), libro.get());
        alquilerRepository.save(alquiler);
        return HttpStatus.OK + ": Alquiler registrado exitosamente";
    }

    public String update(Long id, AlquilerDTO dto) {
        Optional<Alquileres> existing = alquilerRepository.findById(id);
        if (existing.isEmpty()) return HttpStatus.BAD_REQUEST + ": El alquiler no existe";

        Optional<Users> usuario = usuarioRepository.findById(dto.getUsuarioId().intValue());
        Optional<Libros> libro = libroRepository.findById(dto.getLibroId());

        if (usuario.isEmpty()) return HttpStatus.BAD_REQUEST + ": Usuario no encontrado";
        if (libro.isEmpty()) return HttpStatus.BAD_REQUEST + ": Libro no encontrado";
        if (!libro.get().isDisponible()) {
            return HttpStatus.BAD_REQUEST + ": El libro no está disponible para alquiler";
        }
        Alquileres actualizado = updateFields(existing.get(), dto, usuario.get(), libro.get());
        alquilerRepository.save(actualizado);
        return HttpStatus.OK + ": Alquiler actualizado correctamente";
    }

    public String delete(Long id) {
        if (!alquilerRepository.existsById(id)) {
            return HttpStatus.BAD_REQUEST + ": Alquiler no encontrado o ya eliminado";
        }
        alquilerRepository.deleteById(id);
        return HttpStatus.OK + ": Alquiler eliminado correctamente";
    }

    // Métodos auxiliares

    private Alquileres convertToModel(AlquilerDTO dto, Users usuario, Libros libro) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Alquileres alquiler = new Alquileres();
            alquiler.setUsuario(usuario);
            alquiler.setLibro(libro);
            alquiler.setFechaAlquiler(new java.sql.Date(sdf.parse(dto.getFechaAlquiler()).getTime()));
            alquiler.setFechaDevolucion(new java.sql.Date(sdf.parse(dto.getFechaDevolucion()).getTime()));
            return alquiler;
        } catch (ParseException e) {
            throw new RuntimeException("Error al parsear fechas del alquiler", e);
        }
    }

    private Alquileres updateFields(Alquileres alquiler, AlquilerDTO dto, Users usuario, Libros libro) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            alquiler.setUsuario(usuario);
            alquiler.setLibro(libro);
            alquiler.setFechaAlquiler(new java.sql.Date(sdf.parse(dto.getFechaAlquiler()).getTime()));
            alquiler.setFechaDevolucion(new java.sql.Date(sdf.parse(dto.getFechaDevolucion()).getTime()));
            return alquiler;
        } catch (ParseException e) {
            throw new RuntimeException("Error al parsear fechas del alquiler", e);
        }
    }
}