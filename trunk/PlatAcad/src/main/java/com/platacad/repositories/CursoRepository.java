package com.platacad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.platacad.entities.Curso;
import com.platacad.to.CursoMatriculadoTO;

public interface CursoRepository extends JpaRepository<Curso, Integer>, JpaSpecificationExecutor {

}
