package com.gruposeleccion.app.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "PERFILFASE")
public class PerfilFase {

	@EmbeddedId
    private PerfilFaseId id;

    // Otros atributos, getters y setters

    public PerfilFaseId getId() {
        return id;
    }

    public void setId(PerfilFaseId id) {
        this.id = id;
    }

    // Otros getters y setters
}
