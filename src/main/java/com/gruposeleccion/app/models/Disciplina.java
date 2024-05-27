package com.gruposeleccion.app.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "DISCIPLINA")
public class Disciplina {
	@Id
    @Column(name = "IDDISCIPLINA")
    private String idDisciplina;

    @Column(name = "DESCDISCIPLINA")
    private String descDisciplina;
    
    @OneToMany
    @JoinColumn(name = "IDDISCIPLINA")
    private List<Perfil> perfiles;

    // Getters and setters
    public String getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(String idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public String getDescDisciplina() {
        return descDisciplina;
    }

    public void setDescDisciplina(String descDisciplina) {
        this.descDisciplina = descDisciplina;
    }

	public List<Perfil> getPerfiles() {
		return perfiles;
	}

	public void setPerfiles(List<Perfil> perfiles) {
		this.perfiles = perfiles;
	}
}
