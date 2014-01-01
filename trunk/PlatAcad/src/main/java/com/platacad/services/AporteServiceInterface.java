package com.platacad.services;

import java.util.List;

import com.platacad.model.entities.Articulo;

public interface AporteServiceInterface {

	public void registrarAporte(Articulo articulo);

	public List<Articulo> getAportes(Integer cursoId);
}
