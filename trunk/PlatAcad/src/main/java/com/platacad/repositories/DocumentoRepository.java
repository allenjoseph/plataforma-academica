package com.platacad.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.platacad.model.entities.Documento;

public interface DocumentoRepository extends JpaRepository<Documento, Integer>{

	@Query("select d from Documento d where lower(d.titulo) like ('%' || lower(:text) || '%')")
	public List<Documento> filtrarDocumentos(@Param("text") String text);
}
