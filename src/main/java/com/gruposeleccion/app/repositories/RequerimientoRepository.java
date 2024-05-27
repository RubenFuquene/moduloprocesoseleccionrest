package com.gruposeleccion.app.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gruposeleccion.app.models.Requerimiento;

import jakarta.transaction.Transactional;

public interface RequerimientoRepository extends JpaRepository<Requerimiento, Long> {

	@Modifying
    @Transactional
    @Query(value = "INSERT INTO REQUERIMIENTO (CONSECREQUERIMIENTO, CONDEMPLEADO, EMP_CONDEMPLEADO, FECHAREQUERIMIENTO, SALARIOMAX, SALARIOMIN, DESFUNCION, DESCARRERAS, NVACANTES) " +
                   "VALUES (secuencia_requerimiento.NEXTVAL, ?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8)", nativeQuery = true)
    void insertRequerimiento(
    		String condEmpleado,
    		String empCondEmpleado,
    		Date fechaRequerimiento,
    		int salarioMax,
    		int salarioMin,
    		String desFuncion,
    		String descCarreras,
    		int nVacantes);
	
	@Query(value = "SELECT * FROM REQUERIMIENTO WHERE EMP_CONDEMPLEADO = :empCondEmpleado", nativeQuery = true)
    List<Requerimiento> findByEmpCondEmpleado(@Param("empCondEmpleado") String empCondEmpleado);
	
	@Query(value = "SELECT * FROM REQUERIMIENTO WHERE CONSECREQUERIMIENTO = (SELECT MAX(r.CONSECREQUERIMIENTO) FROM REQUERIMIENTO r)", nativeQuery = true)
    Requerimiento findLastInsertedRequerimiento();
}
