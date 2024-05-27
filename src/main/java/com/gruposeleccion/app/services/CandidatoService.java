package com.gruposeleccion.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gruposeleccion.app.models.Candidato;
import com.gruposeleccion.app.repositories.CandidatoRepository;

@Service
public class CandidatoService {
	@Autowired
    private CandidatoRepository candidatoRepository;

    public List<Candidato> buscarCandidatos(String descDisciplina, String descTipoItemPerfil) {
        return candidatoRepository.findByDisciplinaOrEstudio(descDisciplina, descTipoItemPerfil);
    }
}
