package com.platacad.services;

import java.util.List;

import com.platacad.model.entities.TrabajoEncargado;

public interface TrabajoServiceInterface {

	public TrabajoEncargado registrarTrabajo(TrabajoEncargado trabajoEncargado);
	
	public List<TrabajoEncargado> obtenerTrabajos();
}
