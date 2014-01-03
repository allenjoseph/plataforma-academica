package com.platacad.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platacad.business.ExamenBusiness;
import com.platacad.model.entities.Examen;

@Service
public class ExamenService implements ExamenServiceInterface {
	
	@Autowired
	ExamenBusiness examenBusiness;

	public Examen registrarExamen(Examen examen) {		
		return examenBusiness.registrarExamen(examen);
	}

	public List<Examen> obtenerExamenes() {
		return examenBusiness.obtenerExamenes();
	}

}
