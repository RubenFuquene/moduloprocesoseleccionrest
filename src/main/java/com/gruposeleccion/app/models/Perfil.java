package com.gruposeleccion.app.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PERFIL")
public class Perfil {

	@Id
    @Column(name = "IDPERFIL")
    private String idPerfil;

    @Column(name = "DESCPERFIL")
    private String descPerfil;

    // Getters and setters
    public String getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(String idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getDescPerfil() {
        return descPerfil;
    }

    public void setDescPerfil(String descPerfil) {
        this.descPerfil = descPerfil;
    }
}
