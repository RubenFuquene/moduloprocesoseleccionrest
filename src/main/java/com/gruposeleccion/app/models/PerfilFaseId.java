package com.gruposeleccion.app.models;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PerfilFaseId implements Serializable {

	@Column(name = "IDPERFIL")
    private String idPerfil;

    @Column(name = "IDFASE")
    private String idFase;

    // getters, setters, equals, and hashCode
    
    public PerfilFaseId() {
    }
    
    public PerfilFaseId(String idPerfil, String idFase) {
        this.idPerfil = idPerfil;
        this.idFase = idFase;
    }

    // Getters and Setters
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

    // Equals and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PerfilFaseId that = (PerfilFaseId) o;
        return Objects.equals(idPerfil, that.idPerfil) &&
                Objects.equals(idFase, that.idFase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPerfil, idFase);
    }
}
