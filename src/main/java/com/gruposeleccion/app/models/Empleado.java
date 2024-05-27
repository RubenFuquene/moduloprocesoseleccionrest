package com.gruposeleccion.app.models;

import jakarta.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "EMPLEADO")
public class Empleado {
	
	@Id
	@Column(name = "CONDEMPLEADO")
    private String condEmpleado;
	
	@Column(name = "NOMEMPLEADO")
    private String nomEmpleado;
	
	@Column(name = "APELLEMPLEADO")
    private String apelEmpleado;
	
    @Temporal(TemporalType.DATE)
    @Column(name = "FECHANAC")
    private Date fechaNac;

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHAINGRE")
    private Date fechaIngre;

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHAEGRESO")
    private Date fechaEgreso;

    @Column(name = "CORREO")
    private String correo;

    @ManyToMany
    @JoinTable(name = "CARGO",
               joinColumns = @JoinColumn(name = "CONDEMPLEADO"),
               inverseJoinColumns = @JoinColumn(name = "IDTIPOCARGO"))
    private Set<TipoCargo> tiposCargos = new HashSet<>();

	public String getCondEmpleado() {
		return condEmpleado;
	}

	public void setCondEmpleado(String condEmpleado) {
		this.condEmpleado = condEmpleado;
	}

	public String getNomEmpleado() {
		return nomEmpleado;
	}

	public void setNomEmpleado(String nomEmpleado) {
		this.nomEmpleado = nomEmpleado;
	}

	public String getApelEmpleado() {
		return apelEmpleado;
	}

	public void setApelEmpleado(String apelEmpleado) {
		this.apelEmpleado = apelEmpleado;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public Date getFechaIngre() {
		return fechaIngre;
	}

	public void setFechaIngre(Date fechaIngre) {
		this.fechaIngre = fechaIngre;
	}

	public Date getFechaEgreso() {
		return fechaEgreso;
	}

	public void setFechaEgreso(Date fechaEgreso) {
		this.fechaEgreso = fechaEgreso;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Set<TipoCargo> getTiposCargos() {
		return tiposCargos;
	}

	public void setTiposCargos(Set<TipoCargo> tiposCargos) {
		this.tiposCargos = tiposCargos;
	}	
}
