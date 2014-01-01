package com.platacad.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platacad.business.AporteBusiness;
import com.platacad.model.entities.Articulo;

@Service
public class AporteService implements AporteServiceInterface {

	@Autowired
	AporteBusiness aporteBusiness;

	public void registrarAporte(Articulo aporte) {
		aporteBusiness.registrarAporte(aporte);
	}

	public List<Articulo> getAportes(Integer cursoId) {		
		return aporteBusiness.getAportes(cursoId);
	}

}
