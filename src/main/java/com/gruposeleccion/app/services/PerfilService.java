package com.gruposeleccion.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gruposeleccion.app.models.Perfil;
import com.gruposeleccion.app.repositories.PerfilRepository;

@Service
public class PerfilService {

	@Autowired
    private PerfilRepository perfilRepository;

    public List<Perfil> getPerfilesByDisciplina(String idDisciplina) {
        return perfilRepository.findByIdDisciplina(idDisciplina);
    }
}
