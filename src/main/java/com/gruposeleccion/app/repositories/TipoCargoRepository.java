package com.gruposeleccion.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gruposeleccion.app.models.TipoCargo;

public interface TipoCargoRepository extends JpaRepository<TipoCargo, String> {
	
	@Query(value = "SELECT * FROM TIPOCARGO", nativeQuery = true)
    List<TipoCargo> findAllTipoCargos();
}
