package com.gruposeleccion.app.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "DISCIPLINA2")
public class Disciplina2 {
	@Id
    @Column(name = "IDDISCIPLINA2")
    private String idDisciplina2;

	@Column(name = "DESCDISCIPLINA2")
    private String descDisciplina2;
	
	@OneToMany
    @JoinColumn(name = "IDDISCIPLINA2")
    private List<Candidato> candidatos;

	public String getIdDisciplina2() {
		return idDisciplina2;
	}

	public void setIdDisciplina2(String idDisciplina2) {
		this.idDisciplina2 = idDisciplina2;
	}

	public String getDescDisciplina2() {
		return descDisciplina2;
	}

	public void setDescDisciplina2(String descDisciplina2) {
		this.descDisciplina2 = descDisciplina2;
	}

	public List<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(List<Candidato> candidatos) {
		this.candidatos = candidatos;
	}
	
	
}
