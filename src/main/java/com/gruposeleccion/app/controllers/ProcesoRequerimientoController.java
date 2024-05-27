package com.gruposeleccion.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gruposeleccion.app.models.PerfilFase;
import com.gruposeleccion.app.models.PerfilFaseId;
import com.gruposeleccion.app.models.ProcesoRequerimiento;
import com.gruposeleccion.app.services.PerfilFaseService;
import com.gruposeleccion.app.services.ProcesoRequerimientoService;

@RestController
@RequestMapping("/procesos-requerimiento")
public class ProcesoRequerimientoController {
	
	@Autowired
    private ProcesoRequerimientoService procesoRequerimientoService;
	
	@Autowired
	private PerfilFaseService perfilFaseService;

    @PostMapping
    public ResponseEntity<?> crearProcesoRequerimiento(@RequestBody ProcesoRequerimiento procesoRequerimiento) {
    	PerfilFaseId perfilFaseId = new PerfilFaseId(procesoRequerimiento.getId().getIdPerfil(), procesoRequerimiento.getId().getIdFase());
        PerfilFase perfilFase = new PerfilFase();
        perfilFase.setId(perfilFaseId);
        perfilFaseService.guardarPerfilFase(perfilFase);
        
        ProcesoRequerimiento nuevoProceso = procesoRequerimientoService.guardarProcesoRequerimiento(procesoRequerimiento);
        return new ResponseEntity<>(nuevoProceso, HttpStatus.CREATED);
    }
}
