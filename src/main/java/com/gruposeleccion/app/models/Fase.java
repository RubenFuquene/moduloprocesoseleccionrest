package com.gruposeleccion.app.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "FASE")
public class Fase {

	@Id
    @Column(name = "IDFASE")
    private String idFase;

    @Column(name = "DESFASE")
    private String desFase;

	public String getIdFase() {
		return idFase;
	}

	public void setIdFase(String idFase) {
		this.idFase = idFase;
	}

	public String getDesFase() {
		return desFase;
	}

	public void setDesFase(String desFase) {
		this.desFase = desFase;
	}
}
