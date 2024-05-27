package com.gruposeleccion.app.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "HV")
public class HV {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONSECHV")
    private Long consechv;
	
	@Column(name = "FECHAINIACT")
    private Long fechaIniAct;
	
	@Column(name = "FECHAFINACT")
    private Long FechaFinAct;
	
	@Column(name = "DESCACTIVIDAD")
    private Long DescActividad;
	
	@Column(name = "FUNCIONACTIVIDAD")
    private Long FuncionActividad;

	public Long getConsechv() {
		return consechv;
	}

	public void setConsechv(Long consechv) {
		this.consechv = consechv;
	}

	public Long getFechaIniAct() {
		return fechaIniAct;
	}

	public void setFechaIniAct(Long fechaIniAct) {
		this.fechaIniAct = fechaIniAct;
	}

	public Long getFechaFinAct() {
		return FechaFinAct;
	}

	public void setFechaFinAct(Long fechaFinAct) {
		FechaFinAct = fechaFinAct;
	}

	public Long getDescActividad() {
		return DescActividad;
	}

	public void setDescActividad(Long descActividad) {
		DescActividad = descActividad;
	}

	public Long getFuncionActividad() {
		return FuncionActividad;
	}

	public void setFuncionActividad(Long funcionActividad) {
		FuncionActividad = funcionActividad;
	}
}
