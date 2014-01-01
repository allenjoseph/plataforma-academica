package com.platacad.business;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.platacad.model.entities.Articulo;
import com.platacad.model.entities.CursoAperturado;
import com.platacad.model.enums.EstadoEntidad;
import com.platacad.repositories.AporteRepository;

@Component
public class AporteBusiness {

	@Resource
	AporteRepository aporteRepository;
	
	public void registrarAporte(Articulo aporte){
		aporte.setEstado(EstadoEntidad.ACTIVO.getCodigo());
		aporteRepository.save(aporte);
	}

	public List<Articulo> getAportes(Integer cursoId) {
		List<Articulo> lista = aporteRepository.findByIdCursoAperturadoFk(new CursoAperturado(cursoId));
		return lista;
	}
}
