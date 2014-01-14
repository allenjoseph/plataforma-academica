package com.platacad.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.platacad.model.entities.CursoAperturado;
import com.platacad.model.entities.Examen;

public interface ExamenRepository extends JpaRepository<Examen, Integer>{
	
	public List<Examen> findByIdCursoAperturadoFk(CursoAperturado curso);

}
