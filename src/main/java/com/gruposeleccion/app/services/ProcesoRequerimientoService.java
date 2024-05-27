package com.gruposeleccion.app.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gruposeleccion.app.models.ProcesoRequerimiento;
import com.gruposeleccion.app.models.ProcesoRequerimientoId;
import com.gruposeleccion.app.repositories.ProcesoRequerimientoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Service
public class ProcesoRequerimientoService {

	@Autowired
    private ProcesoRequerimientoRepository procesoRequerimientoRepository;
	
	@PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public ProcesoRequerimiento guardarProcesoRequerimiento(ProcesoRequerimiento procesoRequerimiento) {
    	// Obtener el CONSECREQUERIMIENTO de la entidad
        Long consecRequerimiento = procesoRequerimiento.getId().getConsecRequerimiento();

        // Contar cuántos registros existen para el mismo CONSECREQUERIMIENTO
        Long cantidadProcesos = procesoRequerimientoRepository.countByConsecRequerimiento(consecRequerimiento);

        // Establecer el valor de CONSPROCESO en la cantidad de procesos más uno
        procesoRequerimiento.getId().setConsProceso(cantidadProcesos + 1);

        System.out.println(procesoRequerimiento.getId().getConsProceso());
        // Guardar la entidad
        return procesoRequerimientoRepository.save(procesoRequerimiento);
    }
}
