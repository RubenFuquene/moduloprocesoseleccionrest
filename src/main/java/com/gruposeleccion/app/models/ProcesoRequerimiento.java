package com.gruposeleccion.app.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PROCESOREQUERIMIENTO")
public class ProcesoRequerimiento {
	
	@EmbeddedId
    private ProcesoRequerimientoId id;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "IDPERFIL", referencedColumnName = "IDPERFIL", insertable = false, updatable = false),
        @JoinColumn(name = "IDFASE", referencedColumnName = "IDFASE", insertable = false, updatable = false)
    })
    private PerfilFase perfilFase;

    @Column(name = "CONDEMPLEADO")
    private String condEmpleado;

    @Column(name = "FECHAINICIO")
    private Date fechaInicio;

    @Column(name = "FECHAFIN")
    private Date fechaFin;

    @Column(name = "CONVOCATORIA")
    private String convocatoria;

    @Column(name = "INVITACION")
    private String invitacion;

    // 	Getters y setters
    
    public ProcesoRequerimientoId getId() {
        return id;
    }

    public void setId(ProcesoRequerimientoId id) {
        this.id = id;
    }

    public PerfilFase getPerfilFase() {
        return perfilFase;
    }

    public void setPerfilFase(PerfilFase perfilFase) {
        this.perfilFase = perfilFase;
    }

	public String getCondEmpleado() {
		return condEmpleado;
	}

	public void setCondEmpleado(String condEmpleado) {
		this.condEmpleado = condEmpleado;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getConvocatoria() {
		return convocatoria;
	}

	public void setConvocatoria(String convocatoria) {
		this.convocatoria = convocatoria;
	}

	public String getInvitacion() {
		return invitacion;
	}

	public void setInvitacion(String invitacion) {
		this.invitacion = invitacion;
	}   
    
}
