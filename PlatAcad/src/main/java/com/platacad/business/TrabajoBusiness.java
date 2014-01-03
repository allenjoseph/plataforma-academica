package com.platacad.business;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;

import com.platacad.model.entities.TrabajoEncargado;
import com.platacad.model.enums.EstadoEntidad;
import com.platacad.repositories.TrabajoRepository;

@Controller
public class TrabajoBusiness {
	
	@Resource
	TrabajoRepository trabajoRepository;

	public TrabajoEncargado registrarTrabajo(TrabajoEncargado trabajoEncargado) {
		trabajoEncargado.setEstado(EstadoEntidad.ACTIVO.getCodigo());
		return trabajoRepository.save(trabajoEncargado);
	}
	
	public List<TrabajoEncargado> obtenerTrabajos(){
		return trabajoRepository.findAll(new Sort(Direction.ASC,"fechaPresentacion"));
	}

}
