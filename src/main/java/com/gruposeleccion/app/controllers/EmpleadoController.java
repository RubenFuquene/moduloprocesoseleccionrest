package com.gruposeleccion.app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gruposeleccion.app.models.Cargo;
import com.gruposeleccion.app.models.Empleado;
import com.gruposeleccion.app.services.EmpleadoService;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
	
	@Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public List<Empleado> getAllEmpleados() {
        return empleadoService.getAllEmpleados();
    }

    @PostMapping
    public Empleado createEmpleado(@RequestBody Empleado empleado) {
        return empleadoService.saveEmpleado(empleado);
    }

    @PostMapping("/{condEmpleado}/cargos")
    public void addCargoToEmpleado(@PathVariable("condEmpleado") String condEmpleado, @RequestBody Cargo cargo) {
        empleadoService.addCargoToEmpleado(condEmpleado, cargo);
    }
    
    @GetMapping("/analistas-generales")
    public List<Empleado> getAnalistasGenerales() {
        return empleadoService.getAnalistasGenerales();
    }
    
    @PostMapping("/{condEmpleado}")
    public Optional<Empleado> getEmpleadoByCondEmpleado(@PathVariable("condEmpleado") String condEmpleado) {
        return empleadoService.getEmpleadoByCondEmpleadoWithCargos(condEmpleado);
    }
}
