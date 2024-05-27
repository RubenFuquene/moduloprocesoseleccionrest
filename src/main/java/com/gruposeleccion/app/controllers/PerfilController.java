package com.gruposeleccion.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gruposeleccion.app.models.Disciplina;
import com.gruposeleccion.app.models.Perfil;
import com.gruposeleccion.app.services.DisciplinaService;
import com.gruposeleccion.app.services.PerfilService;

@RestController
@RequestMapping("/perfiles")
public class PerfilController {
	@Autowired
    private PerfilService perfilService;
	
	@Autowired
	private DisciplinaService disciplinaService;

    @GetMapping("/disciplina/{idDisciplina}")
    public List<Perfil> getPerfilesByDisciplina(@PathVariable("idDisciplina") String idDisciplina) {
        return perfilService.getPerfilesByDisciplina(idDisciplina);
    }
    
    @GetMapping("/perfil/{idPerfil}/disciplina")
    public Disciplina getDisciplinaByPerfil(@PathVariable("idPerfil") String idPerfil) {
    	return disciplinaService.findByPerfilId(idPerfil);
    }
}
