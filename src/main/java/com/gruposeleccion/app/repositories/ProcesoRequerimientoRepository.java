package com.gruposeleccion.app.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gruposeleccion.app.models.ProcesoRequerimiento;
import com.gruposeleccion.app.models.ProcesoRequerimientoId;

import jakarta.transaction.Transactional;

public interface ProcesoRequerimientoRepository extends JpaRepository<ProcesoRequerimiento, ProcesoRequerimientoId> {
	
	@Modifying
    @Transactional
    @Query(value = "INSERT INTO PROCESOREQUERIMIENTO (CONSECREQUERIMIENTO, IDPERFIL, IDFASE, CONSPROCESO, CONDEMPLEADO, FECHAINICIO, FECHAFIN, CONVOCATORIA, INVITACION)" +
                   "VALUES (:#{#procesoRequerimiento.id.consecRequerimiento}, :#{#procesoRequerimiento.id.idPerfil}, :#{#procesoRequerimiento.id.idFase}, " +
                   "secuencia_proceso_req.NEXTVAL, :#{#procesoRequerimiento.condEmpleado}, :#{#procesoRequerimiento.fechaInicio}, :#{#procesoRequerimiento.fechaFin}, " +
                   ":#{#procesoRequerimiento.convocatoria}, :#{#procesoRequerimiento.invitacion})", nativeQuery = true)
    void insertProcesoRequerimiento(ProcesoRequerimiento procesoRequerimiento);

	@Query(value = "SELECT * FROM PROCESOREQUERIMIENTO WHERE CONSPROCESO = (SELECT MAX(p.CONSPROCESO) FROM PROCESOREQUERIMIENTO p)", nativeQuery = true)
    ProcesoRequerimiento findByCurrentSequence();
	
	@Query(value = "SELECT COUNT(*) FROM PROCESOREQUERIMIENTO WHERE CONSECREQUERIMIENTO = :consecRequerimiento", nativeQuery = true)
	Long countByConsecRequerimiento(@Param("consecRequerimiento") Long consecRequerimiento);
	
	@Query(value = "SELECT * FROM PROCESOREQUERIMIENTO WHERE CONSECREQUERIMIENTO = :consecRequerimiento ORDER BY CONSPROCESO", nativeQuery = true)
    List<ProcesoRequerimiento> findByConsecRequerimiento(@Param("consecRequerimiento") Long consecRequerimiento);
}
