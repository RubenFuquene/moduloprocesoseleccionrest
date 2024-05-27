package com.gruposeleccion.app.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TIPOITEMPERFIL2")
public class TipoItemPerfil2 {
	
	@Id
    @Column(name = "IDTIPOITEMPERFIL2")
    private String idTipoItemPerfil2;
	
	@Column(name = "DESCTIPOITEMPERFIL2")
    private String descTipoItemPerfil2;
	
	@OneToMany
    @JoinColumn(name = "IDTIPOITEMPERFIL2")
    private List<HV> hojasVida;

	public String getIdTipoItemPerfil2() {
		return idTipoItemPerfil2;
	}

	public void setIdTipoItemPerfil2(String idTipoItemPerfil2) {
		this.idTipoItemPerfil2 = idTipoItemPerfil2;
	}

	public String getDescTipoItemPerfil2() {
		return descTipoItemPerfil2;
	}

	public void setDescTipoItemPerfil2(String descTipoItemPerfil2) {
		this.descTipoItemPerfil2 = descTipoItemPerfil2;
	}

	public List<HV> getHojasVida() {
		return hojasVida;
	}

	public void setHojasVida(List<HV> hojasVida) {
		this.hojasVida = hojasVida;
	}
}
