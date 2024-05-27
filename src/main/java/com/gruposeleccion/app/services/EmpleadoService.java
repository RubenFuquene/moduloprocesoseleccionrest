package com.gruposeleccion.app.services;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.gruposeleccion.app.models.Cargo;
import com.gruposeleccion.app.models.Empleado;
import com.gruposeleccion.app.repositories.CargoRepository;
import com.gruposeleccion.app.repositories.EmpleadoRepository;

@Service
public class EmpleadoService {

	@Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private CargoRepository cargoRepository;
    
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int ID_LENGTH = 5;
    private static final Random RANDOM = new Random();

    public List<Empleado> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    @Transactional
    public Empleado saveEmpleado(Empleado empleado) {
    	if (empleado.getCondEmpleado() == null || empleado.getCondEmpleado().isEmpty()) {
            empleado.setCondEmpleado(generateUniqueCondEmpleado());
        }
    	
        empleadoRepository.insertEmpleado(
            empleado.getCondEmpleado(),
            empleado.getNomEmpleado(),
            empleado.getApelEmpleado(),
            empleado.getFechaNac(),
            empleado.getFechaIngre(),
            empleado.getFechaEgreso(),
            empleado.getCorreo()
        );
        
        return empleado;
    }

    @Transactional
    public void addCargoToEmpleado(String condEmpleado, Cargo cargo) {
        Empleado empleado = empleadoRepository.findById(condEmpleado).orElseThrow(() -> new RuntimeException("Empleado not found"));
        cargoRepository.insertCargo(
    		empleado.getCondEmpleado(),
            cargo.getTipoCargo().getIdTipoCargo(),
            cargo.getFechaInicioCargo(),
            cargo.getFechaFinCargo(),
            cargo.getDescCargo()
        );
    }
    
    private String generateUniqueCondEmpleado() {
        String condEmpleado;
        do {
            condEmpleado = generateRandomString();
        } while (empleadoRepository.existsById(condEmpleado));
        return condEmpleado;
    }

    private String generateRandomString() {
        StringBuilder sb = new StringBuilder(ID_LENGTH);
        for (int i = 0; i < ID_LENGTH; i++) {
            sb.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }
    
    @Transactional(readOnly = true)
    public List<Empleado> getAnalistasGenerales() {
        return empleadoRepository.findAnalistasGenerales();
    }
    
    public Optional<Empleado> getEmpleadoByCondEmpleadoWithCargos(String condEmpleado) {
        return empleadoRepository.findByCondEmpleadoWithCargos(condEmpleado);
    }
}
