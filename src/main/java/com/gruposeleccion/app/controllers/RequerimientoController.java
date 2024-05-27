package com.gruposeleccion.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gruposeleccion.app.models.Requerimiento;
import com.gruposeleccion.app.services.RequerimientoService;

@RestController
@RequestMapping("/requerimientos")
public class RequerimientoController {
	@Autowired
    private RequerimientoService requerimientoService;

    @PostMapping
    public Requerimiento createRequerimiento(@RequestBody Requerimiento request) {
        return requerimientoService.createRequerimiento(
        		request.getEmpleado().getCondEmpleado(),
        		request.getEmpleadoSeleccionado().getCondEmpleado(),
    			request.getSalarioMax(),
    			request.getSalarioMin(),
				request.getDesFuncion(),
				request.getDescCarreras(),
				request.getnVacantes());
    }
    
    @GetMapping("/asignados/{empCondEmpleado}")
    public List<Requerimiento> getRequerimientosByEmpCondEmpleado(@PathVariable("empCondEmpleado") String empCondEmpleado) {
        return requerimientoService.findByEmpCondEmpleado(empCondEmpleado);
    }
}
