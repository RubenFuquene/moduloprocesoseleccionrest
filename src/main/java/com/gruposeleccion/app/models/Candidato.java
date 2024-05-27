package com.gruposeleccion.app.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "CANDIDATO")
public class Candidato {
	@Id
    @Column(name = "USUARIO")
    private String usuario;
	
	@Column(name = "NOMBRE")
    private String nombre;
	
	@Column(name = "APELLIDO")
    private String apellido;
	
	@Column(name = "FECHANAC")
    private String fechaNac;
	
	@Column(name = "NDOC")
    private String nDoc;
	
	@OneToMany
    @JoinColumn(name = "USUARIO")
    private List<HV> hojasVida;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getnDoc() {
		return nDoc;
	}

	public void setnDoc(String nDoc) {
		this.nDoc = nDoc;
	}

	public List<HV> getHojasVida() {
		return hojasVida;
	}

	public void setHojasVida(List<HV> hojasVida) {
		this.hojasVida = hojasVida;
	}

}
