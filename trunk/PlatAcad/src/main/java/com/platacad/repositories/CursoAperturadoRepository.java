package com.platacad.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.platacad.model.entities.Ciclo;
import com.platacad.model.entities.CursoAperturado;
import com.platacad.model.entities.Usuario;

public interface CursoAperturadoRepository extends JpaRepository<CursoAperturado, Integer> {

	public List<CursoAperturado> findByIdCicloFk(Ciclo ciclo);
	
	public List<CursoAperturado> findByIdCicloFkAndIdDocenteFk(Integer ciclo, Usuario usuario);

	@Query("select count(m) from Matricula m where m.idCursoAperturadoFk.idCursoAperturado = (:id)")
	public Integer getTotalMatriculados(@Param("id") Integer cursoAperturado);
	
	@Query("select count(a) from Articulo a where a.idCursoAperturadoFk.idCursoAperturado = (:id)")
	public Integer getTotalArticulos(@Param("id") Integer cursoAperturado);
	
	@Query("select count(t) from TrabajoEncargado t where t.idCursoAperturadoFk.idCursoAperturado = (:id)")
	public Integer getTotalTrabajos(@Param("id") Integer cursoAperturado);
	
	@Query("select count(e) from Examen e where e.idCursoAperturadoFk.idCursoAperturado = (:id)")
	public Integer getTotalExamenes(@Param("id") Integer cursoAperturado);
}
