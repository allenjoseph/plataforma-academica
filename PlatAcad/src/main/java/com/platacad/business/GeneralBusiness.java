/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.business;

import com.platacad.dao.GeneralDAO;
import com.platacad.helpers.ConverterToTO;
import com.platacad.model.entities.Ciclo;
import com.platacad.model.entities.Curso;
import com.platacad.model.entities.CursoAperturado;
import com.platacad.model.entities.Examen;
import com.platacad.model.entities.Matricula;
import com.platacad.model.entities.Parametros;
import com.platacad.model.entities.TrabajoEncargado;
import com.platacad.model.entities.Usuario;
import com.platacad.model.enums.TipoPeriodoEnum;
import com.platacad.repositories.ExamenRepository;
import com.platacad.repositories.TrabajoRepository;
import com.platacad.to.CursoAsignadoTO;
import com.platacad.to.CursoMatriculadoTO;
import com.platacad.to.CursoTO;
import com.platacad.to.TimelineItemTO;
import com.platacad.to.TipoTO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author allen
 */
@Component
public class GeneralBusiness {
    
    @Autowired
    GeneralDAO generalDAO;
    
    @Resource
    ExamenRepository examenRepository;
    
    @Resource
    TrabajoRepository trabajoRepository;
    
    public List<Matricula> getCursosMatriculados(Integer ciclo, String usuario) {
		return generalDAO.getCursosMatriculados(ciclo, usuario);
	}

	public List<CursoMatriculadoTO> getCursosMatriculadosTO(Integer ciclo, String usuario) {
		return null;
	}

	public List<CursoAperturado> getCursosACargo(Integer ciclo, String usuario) {
		return generalDAO.getCursosACargo(ciclo, usuario);
	}

	public List<TimelineItemTO> getTimeline(Usuario user) {
		List<TimelineItemTO> items = new ArrayList<TimelineItemTO>();
		for(CursoAperturado curso : user.getCursoAperturadoList()){
			for(Examen examen : examenRepository.findByIdCursoAperturadoFk(curso)){
				TimelineItemTO item = new TimelineItemTO();
				item.setFecha(examen.getFechaExamen());
				item.setTitulo("EXAMEN");
				item.setReferencia(examen.getIdCursoAperturadoFk().getIdCursoFk().getNombre());
				items.add(item);
			}
			for(TrabajoEncargado trabajo : trabajoRepository.findByIdCursoAperturadoFk(curso)){
				TimelineItemTO item = new TimelineItemTO();
				item.setFecha(trabajo.getFechaPresentacion());
				item.setTitulo("TRABAJO ENCARGADO");
				item.setReferencia(trabajo.getIdCursoAperturadoFk().getIdCursoFk().getNombre());
				items.add(item);
			}
		}
		return items;
	}
    
}
