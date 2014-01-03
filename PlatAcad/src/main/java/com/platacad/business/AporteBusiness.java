package com.platacad.business;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.platacad.model.entities.Archivo;
import com.platacad.model.entities.Articulo;
import com.platacad.model.entities.CursoAperturado;
import com.platacad.model.enums.EstadoEntidad;
import com.platacad.repositories.AporteRepository;
import com.platacad.repositories.ArchivoRepository;

@Component
public class AporteBusiness {

	@Resource
	AporteRepository aporteRepository;
	
	@Resource
	ArchivoRepository archivoRepository;
	
	public Articulo registrarAporte(Articulo aporte){
		aporte.setEstado(EstadoEntidad.ACTIVO.getCodigo());
		if(aporte.getIdArchivoFk().getContenido() != null){
			Archivo archivo = aporte.getIdArchivoFk();
			archivo.setEstado(EstadoEntidad.ACTIVO.getCodigo());
			archivo.setIdUsuarioFk(aporte.getIdUsuarioFk());
			archivo = archivoRepository.save(archivo);
			aporte.setIdArchivoFk(archivo);
		}
		return aporteRepository.save(aporte);
	}

	public List<Articulo> getAportes(Integer cursoId) {
		List<Articulo> lista = aporteRepository.findByIdCursoAperturadoFk(new CursoAperturado(cursoId));
		return lista;
	}

	public List<Articulo> obtenerAportes() {
		return aporteRepository.findAll(new Sort(Direction.DESC, "idArticuloPk"));
	}
}
