package com.gruposeleccion.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gruposeleccion.app.models.PerfilFase;
import com.gruposeleccion.app.models.PerfilFaseId;
import com.gruposeleccion.app.models.ProcesoRequerimiento;
import com.gruposeleccion.app.models.ProcesoRequerimientoId;
import com.gruposeleccion.app.models.Requerimiento;
import com.gruposeleccion.app.services.PerfilFaseService;
import com.gruposeleccion.app.services.ProcesoRequerimientoService;
import com.gruposeleccion.app.services.RequerimientoService;

@RestController
@RequestMapping("/requerimientos")
public class RequerimientoController {
	@Autowired
    private RequerimientoService requerimientoService;
	
	@Autowired
	private ProcesoRequerimientoService procesoRequerimientoService;
	
	@Autowired
	private PerfilFaseService perfilFaseService;

    @PostMapping
    public Requerimiento createRequerimiento(@RequestBody Requerimiento request) {
        Requerimiento newRequerimiento = requerimientoService.createRequerimiento(
        		request.getEmpleado().getCondEmpleado(),
        		request.getEmpleadoSeleccionado().getCondEmpleado(),
    			request.getSalarioMax(),
    			request.getSalarioMin(),
				request.getDesFuncion(),
				request.getDescCarreras(),
				request.getnVacantes());
        
        ProcesoRequerimiento procesoRequerimiento = new ProcesoRequerimiento();
        
        PerfilFaseId perfilFaseId = new PerfilFaseId("0", "01");
        PerfilFase perfilFase = new PerfilFase();
        perfilFase.setId(perfilFaseId);
        perfilFaseService.guardarPerfilFase(perfilFase);
        
        ProcesoRequerimientoId id = new ProcesoRequerimientoId();
        id.setConsecRequerimiento(newRequerimiento.getConsecrequerimiento());
        id.setIdFase(perfilFaseId.getIdFase());
        id.setIdPerfil(perfilFaseId.getIdPerfil());

        procesoRequerimiento.setId(id);
        procesoRequerimiento.setPerfilFase(perfilFase);
        procesoRequerimiento.setCondEmpleado(newRequerimiento.getEmpleadoSeleccionado().getCondEmpleado());
        procesoRequerimiento.setFechaInicio(newRequerimiento.getFechaRequerimiento());
        procesoRequerimiento.setFechaFin(null);
        procesoRequerimiento.setConvocatoria(null);
        procesoRequerimiento.setInvitacion(null);
        
        procesoRequerimientoService.guardarProcesoRequerimiento(procesoRequerimiento);
        
        return newRequerimiento;
    }
    
    @GetMapping("/asignados/{empCondEmpleado}")
    public List<Requerimiento> getRequerimientosByEmpCondEmpleado(@PathVariable("empCondEmpleado") String empCondEmpleado) {
        return requerimientoService.findByEmpCondEmpleado(empCondEmpleado);
    }
}
