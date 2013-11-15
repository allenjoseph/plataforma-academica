package com.platacad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.platacad.entities.Mensaje;

public interface MensajeRepository  extends JpaRepository<Mensaje, Integer>{

}
