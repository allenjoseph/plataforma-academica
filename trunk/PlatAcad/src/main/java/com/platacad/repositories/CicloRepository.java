package com.platacad.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.platacad.entities.Ciclo;
import com.platacad.entities.Parametros;

public interface CicloRepository extends JpaRepository<Ciclo, Integer>{

	public List<Ciclo> findByAnioAndTipo(Integer anio, Integer tipo);
}
