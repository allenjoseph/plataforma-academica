package com.platacad.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.platacad.model.entities.Articulo;
import com.platacad.model.entities.CursoAperturado;

public interface AporteRepository extends JpaRepository<Articulo, Integer>{
	
	public List<Articulo> findByIdCursoAperturadoFk(CursoAperturado cursoAperturado);
	
}
