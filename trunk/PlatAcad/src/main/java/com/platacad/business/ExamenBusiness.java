package com.platacad.business;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.platacad.model.entities.Examen;
import com.platacad.model.enums.EstadoEntidad;
import com.platacad.model.enums.TipoExamenEnum;
import com.platacad.repositories.ExamenRepository;

@Component
public class ExamenBusiness {
	
	@Resource
	ExamenRepository examenRepository;

	public List<Examen> obtenerExamenes() {
		List<Examen> examenes = examenRepository.findAll(new Sort(Direction.DESC,"fechaExamen"));
		for(Examen examen : examenes){
			examen.setTipoExamenValue(TipoExamenEnum.get(examen.getTipo()).getDescripcion());
		}
		return examenes;
	}

	public Examen registrarExamen(Examen examen) {
		examen.setEstado(EstadoEntidad.ACTIVO.getCodigo());
		return examenRepository.save(examen);
	}

}
