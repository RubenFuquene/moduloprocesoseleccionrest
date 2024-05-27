package com.gruposeleccion.app.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "INSTITUCION")
public class Institucion {

	@Id
	@Column(name = "CODINSTITUCION")
    private Long codInstitucion;
	
	@Column(name = "NOMINSTITUCION")
    private Long nomInstitucion;
	
	@OneToMany
    @JoinColumn(name = "CODINSTITUCION")
    private List<HV> hojasVida;

	public Long getCodInstitucion() {
		return codInstitucion;
	}

	public void setCodInstitucion(Long codInstitucion) {
		this.codInstitucion = codInstitucion;
	}

	public Long getNomInstitucion() {
		return nomInstitucion;
	}

	public void setNomInstitucion(Long nomInstitucion) {
		this.nomInstitucion = nomInstitucion;
	}
	
	
}
