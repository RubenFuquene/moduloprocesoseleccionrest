package com.gruposeleccion.app.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gruposeleccion.app.models.TipoCargo;

import com.gruposeleccion.app.services.TipoCargoService;

@RestController
@RequestMapping("/tipo-cargos")
public class TipoCargoController {

	@Autowired
    private TipoCargoService tipoCargoService;

    @GetMapping
    public List<TipoCargo> getAllTipoCargos() {
        return tipoCargoService.getAllTipoCargos();
    }
}
