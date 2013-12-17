package com.platacad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.platacad.model.entities.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

}
