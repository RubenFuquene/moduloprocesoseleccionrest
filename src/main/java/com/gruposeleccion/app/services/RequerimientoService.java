package com.gruposeleccion.app.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gruposeleccion.app.models.Empleado;
import com.gruposeleccion.app.models.ProcesoRequerimiento;
import com.gruposeleccion.app.models.Requerimiento;
import com.gruposeleccion.app.repositories.EmpleadoRepository;
import com.gruposeleccion.app.repositories.ProcesoRequerimientoRepository;
import com.gruposeleccion.app.repositories.RequerimientoRepository;

import jakarta.transaction.Transactional;

@Service
public class RequerimientoService {
	@Autowired
    private RequerimientoRepository requerimientoRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;
    
    @Autowired
    private ProcesoRequerimientoRepository procesoRequerimientoRepository;

    @Transactional
    public Requerimiento createRequerimiento(
    		String condEmpleado,
    		String empCondEmpleado,
    		int salarioMax,
    		int salarioMin,
            String desFuncion,
            String descCarreras,
            int nVacantes
        ) {
    	
        Empleado empleado = empleadoRepository
        		.findById(condEmpleado)
        		.orElseThrow(() -> new RuntimeException("Empleado not found"));

        Empleado empleadoSeleccionado = null;
        if (empCondEmpleado != null) {
            empleadoSeleccionado = empleadoRepository.findById(empCondEmpleado).orElse(null);
        }

        Requerimiento requerimiento = new Requerimiento();
        requerimiento.setEmpleado(empleado);
        requerimiento.setEmpleadoSeleccionado(empleadoSeleccionado);
        requerimiento.setFechaRequerimiento(new Date());
        requerimiento.setSalarioMax(salarioMax);
        requerimiento.setSalarioMin(salarioMin);
        requerimiento.setDesFuncion(desFuncion);
        requerimiento.setDescCarreras(descCarreras);
        requerimiento.setnVacantes(nVacantes);

        requerimientoRepository.insertRequerimiento(
        		empleado.getCondEmpleado(),
        		empleadoSeleccionado.getCondEmpleado(),
        		new Date(),
        		salarioMax,
        		salarioMin,
        		desFuncion,
        		descCarreras,
        		nVacantes);
        
        return requerimientoRepository.findLastInsertedRequerimiento();
    }
    
    public List<Requerimiento> findByEmpCondEmpleado(String empCondEmpleado) {
    	List<Requerimiento> requerimientos = requerimientoRepository.findByEmpCondEmpleado(empCondEmpleado);
        
        // Itera sobre cada requerimiento para cargar los procesos asociados
        for (Requerimiento requerimiento : requerimientos) {
            List<ProcesoRequerimiento> procesos = requerimiento.getProcesos(procesoRequerimientoRepository);
            requerimiento.setProcesos(procesos);
        }

        return requerimientos;
    }
}
