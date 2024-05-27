package com.gruposeleccion.app.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TIPOCARGO")
public class TipoCargo {
	@Id
	@Column(name = "IDTIPOCARGO")
    private String idTipoCargo;
	@Column(name = "DESCTIPOCARGO")
    private String descTipoCargo;
	
	@ManyToMany(mappedBy = "tiposCargos")
    private Set<Empleado> empleados = new HashSet<>();

    // Getters y setters
    public String getIdTipoCargo() {
        return idTipoCargo;
    }

    public void setIdTipoCargo(String idTipoCargo) {
        this.idTipoCargo = idTipoCargo;
    }

    public String getDescTipoCargo() {
        return descTipoCargo;
    }

    public void setDescTipoCargo(String descTipoCargo) {
        this.descTipoCargo = descTipoCargo;
    }
}
