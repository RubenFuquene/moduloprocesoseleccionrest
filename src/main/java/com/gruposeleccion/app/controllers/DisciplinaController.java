package com.gruposeleccion.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gruposeleccion.app.models.Disciplina;
import com.gruposeleccion.app.services.DisciplinaService;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

	@Autowired
    private DisciplinaService disciplinaService;

    @GetMapping
    public List<Disciplina> getAllDisciplinas() {
        return disciplinaService.getAllDisciplinas();
    }
}
