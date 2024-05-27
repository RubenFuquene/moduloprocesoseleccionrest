package com.gruposeleccion.app.models;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ProcesoRequerimientoId implements Serializable  {
	@Column(name = "CONSECREQUERIMIENTO")
    private Long consecRequerimiento;

    @Column(name = "IDPERFIL")
    private String idPerfil;

    @Column(name = "IDFASE")
    private String idFase;

    @Column(name = "CONSPROCESO")
    private Long consProceso;

    // Getters, setters, equals, and hashCode

    public Long getConsecRequerimiento() {
        return consecRequerimiento;
    }

    public void setConsecRequerimiento(Long consecRequerimiento) {
        this.consecRequerimiento = consecRequerimiento;
    }

    public String getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(String idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getIdFase() {
        return idFase;
    }

    public void setIdFase(String idFase) {
        this.idFase = idFase;
    }

    public Long getConsProceso() {
        return consProceso;
    }

    public void setConsProceso(Long consProceso) {
        this.consProceso = consProceso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProcesoRequerimientoId that = (ProcesoRequerimientoId) o;
        return Objects.equals(consecRequerimiento, that.consecRequerimiento) &&
               Objects.equals(idPerfil, that.idPerfil) &&
               Objects.equals(idFase, that.idFase) &&
               Objects.equals(consProceso, that.consProceso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(consecRequerimiento, idPerfil, idFase, consProceso);
    }
}
