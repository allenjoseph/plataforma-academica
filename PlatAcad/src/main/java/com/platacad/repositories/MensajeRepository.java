package com.platacad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.platacad.model.entities.Mensaje;

public interface MensajeRepository extends JpaRepository<Mensaje, Integer>{

}
