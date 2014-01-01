package com.platacad.business;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.platacad.model.entities.TrabajoEncargado;
import com.platacad.model.enums.EstadoEntidad;
import com.platacad.repositories.TrabajoRepository;

@Controller
public class TrabajoBusiness {
	
	@Resource
	TrabajoRepository trabajoRepository;

	public void registrarTrabajo(TrabajoEncargado trabajoEncargado) {
		trabajoEncargado.setEstado(EstadoEntidad.ACTIVO.getCodigo());
		trabajoRepository.save(trabajoEncargado);
	}

}
