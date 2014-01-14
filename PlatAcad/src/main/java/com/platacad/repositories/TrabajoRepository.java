package com.platacad.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.platacad.model.entities.CursoAperturado;
import com.platacad.model.entities.TrabajoEncargado;

public interface TrabajoRepository extends JpaRepository<TrabajoEncargado, Integer>{

	List<TrabajoEncargado> findByIdCursoAperturadoFk(CursoAperturado curso);

}
