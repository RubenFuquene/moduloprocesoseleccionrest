package com.gruposeleccion.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gruposeleccion.app.models.PerfilFase;
import com.gruposeleccion.app.models.PerfilFaseId;
import com.gruposeleccion.app.repositories.PerfilFaseRepository;

@Service
public class PerfilFaseService {
	
	@Autowired
    private PerfilFaseRepository perfilFaseRepository;

    public PerfilFase guardarPerfilFase(PerfilFase perfilFase) {
    	PerfilFaseId id = perfilFase.getId();
        Optional<PerfilFase> existingPerfilFase = perfilFaseRepository.findById(id);
        
        if (existingPerfilFase.isEmpty()) {
            perfilFaseRepository.insertarPerfilFase(id.getIdPerfil(), id.getIdFase());
            return perfilFase;
        } else {
            return existingPerfilFase.get();
        }
    }

    public Optional<PerfilFase> buscarPorId(PerfilFaseId id) {
        return perfilFaseRepository.findById(id);
    }

    public List<PerfilFase> buscarTodos() {
        return perfilFaseRepository.findAll();
    }
}
