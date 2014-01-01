package com.platacad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platacad.business.TrabajoBusiness;
import com.platacad.model.entities.TrabajoEncargado;

@Service
public class TrabajoService implements TrabajoServiceInterface {
	
	@Autowired
	TrabajoBusiness trabajoBusiness;

	public void registrarTrabajo(TrabajoEncargado trabajoEncargado) {
		trabajoBusiness.registrarTrabajo(trabajoEncargado);		
	}

}
