package com.platacad.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.platacad.entities.Ciclo;
import com.platacad.entities.Matricula;
import com.platacad.entities.Usuario;

public interface MatriculaRepository extends JpaRepository<Matricula, Integer>{

	public List<Matricula> findByIdCicloFkAndIdUsuarioFk(Integer ciclo, String usuario);
}
