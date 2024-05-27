package com.gruposeleccion.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gruposeleccion.app.models.Candidato;
import com.gruposeleccion.app.services.CandidatoService;

@RestController
@RequestMapping("/candidatos")
public class CandidatoController {
	
	@Autowired
    private CandidatoService candidatoService;

    @GetMapping("/buscar/{descDisciplina}/{descTipoItemPerfil}")
    public List<Candidato> buscarCandidatos(
    		@PathVariable("descDisciplina") String descDisciplina,
    		@PathVariable("descTipoItemPerfil") String descTipoItemPerfil) {

        List<Candidato> candidatos = candidatoService.buscarCandidatos(descDisciplina, descTipoItemPerfil);
        
        return candidatos;
    }

}
