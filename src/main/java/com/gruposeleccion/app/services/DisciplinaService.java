package com.gruposeleccion.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gruposeleccion.app.models.Disciplina;
import com.gruposeleccion.app.repositories.DisciplinaRepository;

@Service
public class DisciplinaService {

	@Autowired
    private DisciplinaRepository disciplinaRepository;

	@Transactional(readOnly = true)
    public List<Disciplina> getAllDisciplinas() {
        return disciplinaRepository.findAll();
    }
}
