package com.gruposeleccion.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gruposeleccion.app.models.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, String> {

	@Query(value = "SELECT * FROM PERFIL WHERE IDDISCIPLINA = :idDisciplina", nativeQuery = true)
    List<Perfil> findByIdDisciplina(@Param("idDisciplina") String idDisciplina);
}
