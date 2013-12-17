package com.platacad.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.platacad.model.entities.Ciclo;
import com.platacad.model.entities.CursoAperturado;

public interface CursoAperturadoRepository extends JpaRepository<CursoAperturado, Integer> {

	public List<CursoAperturado> findByIdCicloFk(Ciclo ciclo);
}
