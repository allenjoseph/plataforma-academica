package com.platacad.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platacad.business.TrabajoBusiness;
import com.platacad.model.entities.TrabajoEncargado;

@Service
public class TrabajoService implements TrabajoServiceInterface {
	
	@Autowired
	TrabajoBusiness trabajoBusiness;

	public TrabajoEncargado registrarTrabajo(TrabajoEncargado trabajoEncargado) {
		return trabajoBusiness.registrarTrabajo(trabajoEncargado);		
	}

	public List<TrabajoEncargado> obtenerTrabajos() {
		return trabajoBusiness.obtenerTrabajos();
	}

}
