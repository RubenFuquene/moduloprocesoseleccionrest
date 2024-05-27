package com.gruposeleccion.app.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gruposeleccion.app.repositories.TipoCargoRepository;
import com.gruposeleccion.app.models.TipoCargo;

@Service
public class TipoCargoService {
	
	@Autowired
    private TipoCargoRepository tipoCargoRepository;

    public List<TipoCargo> getAllTipoCargos() {
        return tipoCargoRepository.findAllTipoCargos();
    }
}
