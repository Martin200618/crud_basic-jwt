package com.modelo.seguridad.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.modelo.seguridad.DTO.EditorialDTO;
import com.modelo.seguridad.model.Editoriales;
import com.modelo.seguridad.repository.EditorialRepository;

@Service
public class EditorialService {

    @Autowired
    private EditorialRepository editorialRepository;

    public List<Editoriales> findAll() {
        return editorialRepository.findAll();
    }

    public Optional<Editoriales> findById(Long id) {
        return editorialRepository.findById(id);
    }

    public String save(EditorialDTO dto) {
        Editoriales editorial = new Editoriales();
        editorial.setNombre(dto.getNombre());
        editorial.setPais(dto.getPais());
        editorial.setAnioFundacion(dto.getAnioFundacion());
        editorialRepository.save(editorial);
        return HttpStatus.OK + ": Editorial registrada correctamente";
    }

    public String update(Long id, EditorialDTO dto) {
        Optional<Editoriales> editorialOpt = editorialRepository.findById(id);
        if (editorialOpt.isEmpty()) {
            return HttpStatus.BAD_REQUEST + ": Editorial no encontrada";
        }

        Editoriales editorial = editorialOpt.get();
        editorial.setNombre(dto.getNombre());
        editorial.setPais(dto.getPais());
        editorial.setAnioFundacion(dto.getAnioFundacion());
        editorialRepository.save(editorial);
        return HttpStatus.OK + ": Editorial actualizada correctamente";
    }

    public String delete(Long id) {
        if (!editorialRepository.existsById(id)) {
            return HttpStatus.BAD_REQUEST + ": Editorial no encontrada o ya eliminada";
        }

        editorialRepository.deleteById(id);
        return HttpStatus.OK + ": Editorial eliminada correctamente";
    }
}
