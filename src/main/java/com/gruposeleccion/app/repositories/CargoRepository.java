package com.gruposeleccion.app.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.gruposeleccion.app.models.Cargo;

import jakarta.transaction.Transactional;

public interface CargoRepository extends JpaRepository<Cargo, Long> {

	@Query(value = "SELECT * FROM CARGO", nativeQuery = true)
    List<Cargo> findAllCargos();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO CARGO (CONSECARGO, CONDEMPLEADO, IDTIPOCARGO, FECHAINICIOCARGO, FECHAFINCARGO, DESCCARGO) VALUES (secuencia_cargo.NEXTVAL, ?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
    void insertCargo(String condEmpleado, String idTipoCargo, Date fechaInicioCargo, Date fechaFinCargo, String descCargo);
}
