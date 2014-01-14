package com.platacad.services;

import java.util.List;

import com.platacad.model.entities.Articulo;

public interface AporteServiceInterface {

	public Articulo registrarAporte(Articulo articulo);

	public List<Articulo> getAportes(Integer cursoId);

	public List<Articulo> obtenerAportes();

	public Articulo getAporte(Integer aporteId);
}
