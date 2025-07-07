package com.modelo.seguridad.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.modelo.seguridad.DTO.IdiomaDTO;
import com.modelo.seguridad.model.idioma;
import com.modelo.seguridad.repository.IdiomaRepository;

@Service
public class IdiomaService {

    @Autowired
    private IdiomaRepository idiomaRepository;

    // Obtener todos los idiomas
    public List<idioma> findAll() {
        return idiomaRepository.findAll();
    }

    // Obtener idioma por ID
    public Optional<idioma> findById(Long id) {
        return idiomaRepository.findById(id);
    }

    // Registrar un idioma
    public String save(IdiomaDTO dto) {
        idioma idioma = convertToModel(dto);
        idiomaRepository.save(idioma);
        return HttpStatus.OK.toString() + ": Idioma registrado exitosamente";
    }

    // Actualizar un idioma
    public String update(Long id, IdiomaDTO dto) {
        Optional<idioma> existing = findById(id);
        if (existing.isEmpty()) {
            return HttpStatus.BAD_REQUEST.toString() + ": El idioma no existe";
        }

        idioma idiomaToUpdate = updateFields(existing.get(), dto);
        idiomaRepository.save(idiomaToUpdate);
        return HttpStatus.OK.toString() + ": Idioma actualizado correctamente";
    }

    // Eliminar idioma por ID
    public String delete(Long id) {
        Optional<idioma> idioma = findById(id);
        if (idioma.isEmpty()) {
            return HttpStatus.BAD_REQUEST.toString() + ": El idioma no existe o ya fue eliminado";
        }

        idiomaRepository.deleteById(id);
        return HttpStatus.OK.toString() + ": Idioma eliminado correctamente";
    }

    // Conversión de DTO a Modelo
    private idioma convertToModel(IdiomaDTO dto) {
        idioma idioma = new idioma();
        idioma.setNombre(dto.getNombre());
        idioma.setCodigoIso(dto.getCodigoIso());
        return idioma;
    }

    // Actualización de campos
    private idioma updateFields(idioma idioma, IdiomaDTO dto) {
        idioma.setNombre(dto.getNombre());
        idioma.setCodigoIso(dto.getCodigoIso());
        return idioma;
    }
}