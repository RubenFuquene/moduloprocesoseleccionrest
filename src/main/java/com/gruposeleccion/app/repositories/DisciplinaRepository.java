package com.gruposeleccion.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gruposeleccion.app.models.Disciplina;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, String> {
	
	@Query(value = "SELECT * FROM DISCIPLINA", nativeQuery = true)
    List<Disciplina> findAllDisciplinas();
	
	@Query(value = "SELECT * FROM DISCIPLINA d WHERE d.IDDISCIPLINA = (SELECT p.IDDISCIPLINA FROM PERFIL p WHERE p.IDPERFIL = :idPerfil)", nativeQuery = true)
    Disciplina findByPerfilId(@Param("idPerfil") String idPerfil);
}
