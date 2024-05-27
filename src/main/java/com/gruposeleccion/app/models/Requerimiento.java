package com.gruposeleccion.app.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "REQUERIMIENTO")
public class Requerimiento {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONSECREQUERIMIENTO")
    private Long consecrequerimiento;

    @ManyToOne
    @JoinColumn(name = "CONDEMPLEADO")
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "EMP_CONDEMPLEADO")
    private Empleado empleadoSeleccionado;

    @Column(name = "FECHAREQUERIMIENTO")
    private Date fechaRequerimiento;

    @Column(name = "SALARIOMAX")
    private int salarioMax;

    @Column(name = "SALARIOMIN")
    private int salarioMin;

    @Column(name = "DESFUNCION")
    private String desFuncion;

    @Column(name = "DESCARRERAS")
    private String descCarreras;

    @Column(name = "NVACANTES")
    private int nVacantes;

	public Long getConsecrequerimiento() {
		return consecrequerimiento;
	}

	public void setConsecrequerimiento(Long consecrequerimiento) {
		this.consecrequerimiento = consecrequerimiento;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Empleado getEmpleadoSeleccionado() {
		return empleadoSeleccionado;
	}

	public void setEmpleadoSeleccionado(Empleado empleadoSeleccionado) {
		this.empleadoSeleccionado = empleadoSeleccionado;
	}

	public Date getFechaRequerimiento() {
		return fechaRequerimiento;
	}

	public void setFechaRequerimiento(Date fechaRequerimiento) {
		this.fechaRequerimiento = fechaRequerimiento;
	}

	public int getSalarioMax() {
		return salarioMax;
	}

	public void setSalarioMax(int salarioMax) {
		this.salarioMax = salarioMax;
	}

	public int getSalarioMin() {
		return salarioMin;
	}

	public void setSalarioMin(int salarioMin) {
		this.salarioMin = salarioMin;
	}

	public String getDesFuncion() {
		return desFuncion;
	}

	public void setDesFuncion(String desFuncion) {
		this.desFuncion = desFuncion;
	}

	public String getDescCarreras() {
		return descCarreras;
	}

	public void setDescCarreras(String descCarreras) {
		this.descCarreras = descCarreras;
	}

	public int getnVacantes() {
		return nVacantes;
	}

	public void setnVacantes(int nVacantes) {
		this.nVacantes = nVacantes;
	}
}
