package com.platacad.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.platacad.entities.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, Integer>{

	public List<Matricula> findByIdCicloFkAndIdUsuarioFk(Integer ciclo, String usuario);
}
