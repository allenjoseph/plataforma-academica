package com.platacad.services;

import java.util.List;

import com.platacad.model.entities.Examen;

public interface ExamenServiceInterface {

	Examen registrarExamen(Examen examen);

	List<Examen> obtenerExamenes();

}
