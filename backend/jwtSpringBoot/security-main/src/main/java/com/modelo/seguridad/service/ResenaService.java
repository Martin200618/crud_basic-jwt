package com.modelo.seguridad.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.modelo.seguridad.model.Users;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.modelo.seguridad.DTO.ResenaDTO;
import com.modelo.seguridad.model.Libros;
import com.modelo.seguridad.model.Reseña;
import com.modelo.seguridad.repository.Iuser;
import com.modelo.seguridad.repository.LibroRepository;
import com.modelo.seguridad.repository.ResenaRepository;

@Service
public class ResenaService {

    @Autowired
    private ResenaRepository resenaRepository;

    @Autowired
    private Iuser usuarioRepository;

    @Autowired
    private LibroRepository libroRepository;

    public List<Reseña> findAll() {
        return resenaRepository.findAll();
    }

    public Optional<Reseña> findById(Long id) {
        return resenaRepository.findById(id);
    }

    public String create(ResenaDTO dto) {
        Optional<Users> usuario = usuarioRepository.findById(dto.getUsuarioId().intValue());
        Optional<Libros> libro = libroRepository.findById(dto.getLibroId());

        if (usuario.isEmpty()) {
            return HttpStatus.BAD_REQUEST + ": Usuario no encontrado";
        }
        if (libro.isEmpty()) {
            return HttpStatus.BAD_REQUEST + ": Libro no encontrado";
        }

        Reseña resena = convertToModel(dto, usuario.get(), libro.get());
        resenaRepository.save(resena);
        return HttpStatus.OK + ": Reseña registrada exitosamente";
    }

    public String update(Long id, ResenaDTO dto) {
        Optional<Reseña> existing = resenaRepository.findById(id);
        if (existing.isEmpty()) {
            return HttpStatus.BAD_REQUEST + ": La reseña no existe";
        }
        Optional<Users> usuario = usuarioRepository.findById(dto.getUsuarioId().intValue());
        Optional<Libros> libro = libroRepository.findById(dto.getLibroId());

        if (usuario.isEmpty()) {
            return HttpStatus.BAD_REQUEST + ": Usuario no encontrado";
        }
        if (libro.isEmpty()) {
            return HttpStatus.BAD_REQUEST + ": Libro no encontrado";
        }

        Reseña actualizada = updateFields(existing.get(), dto, usuario.get(), libro.get());
        resenaRepository.save(actualizada);
        return HttpStatus.OK + ": Reseña actualizada exitosamente";
    }

    public String delete(Long id) {
        if (!resenaRepository.existsById(id)) {
            return HttpStatus.BAD_REQUEST + ": Reseña no encontrada o ya eliminada";
        }

        resenaRepository.deleteById(id);
        return HttpStatus.OK + ": Reseña eliminada correctamente";
    }
    private Reseña convertToModel(ResenaDTO dto, Users usuario, Libros libro) {
        try {
            Reseña resena = new Reseña();
            resena.setUsuario(null);
            resena.setLibro(libro);
            resena.setComentario(dto.getComentario());
            resena.setCalificacion(dto.getCalificacion());
            java.util.Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(dto.getFecha());
            resena.setFecha(new java.sql.Date(fecha.getTime()));
            return resena;
        } catch (ParseException e) {
            throw new RuntimeException("Error al convertir fecha: " + dto.getFecha(), e);
        }
    }
    private Reseña updateFields(Reseña resena, ResenaDTO dto, Users usuario, Libros libros) {
        try {
            resena.setUsuario(null);
            resena.setLibro(libros);
            resena.setComentario(dto.getComentario());
            resena.setCalificacion(dto.getCalificacion());
            java.util.Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(dto.getFecha());
            resena.setFecha(new java.sql.Date(fecha.getTime()));
            return resena;
        } catch (ParseException e) {
            throw new RuntimeException("Error al convertir fecha: " + dto.getFecha(), e);
        }
    }
}