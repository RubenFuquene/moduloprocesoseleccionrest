package com.gruposeleccion.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gruposeleccion.app.models.Candidato;

public interface CandidatoRepository extends JpaRepository<Candidato, String> {
	
	@Query(value = "SELECT c.* FROM CANDIDATO c " +
            "LEFT JOIN DISCIPLINA2 d ON c.IDDISCIPLINA2 = d.IDDISCIPLINA2 " +
            "LEFT JOIN HV h ON c.USUARIO = h.USUARIO " +
            "LEFT JOIN TIPOITEMPERFIL2 t ON h.IDTIPOITEMPERFIL2 = t.IDTIPOITEMPERFIL2 " +
            "WHERE d.DESCDISCIPLINA2 = :descDisciplina OR t.DESCTIPOITEMPERFIL2 = :descTipoItemPerfil", 
    nativeQuery = true)
	List<Candidato> findByDisciplinaOrEstudio(@Param("descDisciplina") String descDisciplina, 
                                       @Param("descTipoItemPerfil") String descTipoItemPerfil);
}
