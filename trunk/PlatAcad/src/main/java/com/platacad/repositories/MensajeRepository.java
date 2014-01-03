package com.platacad.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.platacad.model.entities.Mensaje;
import com.platacad.model.entities.Usuario;

public interface MensajeRepository extends JpaRepository<Mensaje, Integer>{

	public List<Mensaje> findByIdUsuarioDestinoFk(Usuario user);
}
