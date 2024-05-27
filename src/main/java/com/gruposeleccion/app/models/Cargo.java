package com.gruposeleccion.app.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CARGO")
public class Cargo {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CONSECARGO")
    private Long conseCargo;

    @ManyToOne
    @JoinColumn(name = "CONDEMPLEADO")
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "IDTIPOCARGO")
    private TipoCargo tipoCargo;

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHAINICIOCARGO")
    private Date fechaInicioCargo;

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHAFINCARGO")
    private Date fechaFinCargo;

    @Column(name = "DESCCARGO")
    private String descCargo;

	public Long getConseCargo() {
		return conseCargo;
	}

	public void setConseCargo(Long conseCargo) {
		this.conseCargo = conseCargo;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public TipoCargo getTipoCargo() {
		return tipoCargo;
	}

	public void setTipoCargo(TipoCargo tipoCargo) {
		this.tipoCargo = tipoCargo;
	}

	public Date getFechaInicioCargo() {
		return fechaInicioCargo;
	}

	public void setFechaInicioCargo(Date fechaInicioCargo) {
		this.fechaInicioCargo = fechaInicioCargo;
	}

	public Date getFechaFinCargo() {
		return fechaFinCargo;
	}

	public void setFechaFinCargo(Date fechaFinCargo) {
		this.fechaFinCargo = fechaFinCargo;
	}

	public String getDescCargo() {
		return descCargo;
	}

	public void setDescCargo(String descCargo) {
		this.descCargo = descCargo;
	}
}
