package com.gruposeleccion.app.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gruposeleccion.app.models.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, String> {
	
	@Query(value = "SELECT * FROM EMPLEADO", nativeQuery = true)
    List<Empleado> findAllEmpleados();
	
	@Modifying
    @Transactional
    @Query(value = "INSERT INTO EMPLEADO (CONDEMPLEADO, NOMEMPLEADO, APELLEMPLEADO, FECHANAC, FECHAINGRE, FECHAEGRESO, CORREO) VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7)", nativeQuery = true)
    void insertEmpleado(String condEmpleado, String nomEmpleado, String apelEmpleado, Date fechaNac, Date fechaIngre, Date fechaEgreso, String correo);
	
	boolean existsById(String condEmpleado);
	
	@Query(value = "SELECT e.* FROM EMPLEADO e " +
            "INNER JOIN CARGO c ON e.CONDEMPLEADO = c.CONDEMPLEADO " +
            "INNER JOIN TIPOCARGO tc ON c.IDTIPOCARGO = tc.IDTIPOCARGO " +
            "WHERE tc.DESCTIPOCARGO = 'Analista General'", nativeQuery = true)
	List<Empleado> findAnalistasGenerales();
	
	@Query(value = "SELECT e.*, c.* " +
            "FROM EMPLEADO e " +
            "LEFT JOIN CARGO ca ON e.CONDEMPLEADO = ca.CONDEMPLEADO " +
            "LEFT JOIN TIPOCARGO c ON ca.IDTIPOCARGO = c.IDTIPOCARGO " +
            "WHERE e.CONDEMPLEADO = :condEmpleado", nativeQuery = true)
	Optional<Empleado> findByCondEmpleadoWithCargos(@Param("condEmpleado") String condEmpleado);
}
