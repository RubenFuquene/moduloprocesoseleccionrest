package com.gruposeleccion.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.gruposeleccion.app.models.PerfilFase;
import com.gruposeleccion.app.models.PerfilFaseId;

import jakarta.transaction.Transactional;

public interface PerfilFaseRepository extends JpaRepository<PerfilFase, PerfilFaseId> {

	@Modifying
    @Transactional
    @Query(value = "INSERT INTO PERFILFASE (IDPERFIL, IDFASE) VALUES (?1, ?2)", nativeQuery = true)
    void insertarPerfilFase(String idPerfil, String idFase);
}
