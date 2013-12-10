/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.business;

import com.platacad.dao.GeneralDAO;
import com.platacad.entities.Ciclo;
import com.platacad.entities.Curso;
import com.platacad.entities.CursoAperturado;
import com.platacad.entities.Matricula;
import com.platacad.entities.Parametros;
import com.platacad.entities.Usuario;
import com.platacad.entities.enums.TipoPeriodoEnum;
import com.platacad.helpers.ConverterToTO;
import com.platacad.to.CursoAsignadoTO;
import com.platacad.to.CursoMatriculadoTO;
import com.platacad.to.CursoTO;
import com.platacad.to.TipoTO;

import java.util.ArrayList;
import java.util.List;

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
    
    public List<Matricula> getCursosMatriculados(Integer ciclo, String usuario) {
		return generalDAO.getCursosMatriculados(ciclo, usuario);
	}

	public List<CursoMatriculadoTO> getCursosMatriculadosTO(Integer ciclo, String usuario) {

		return null;
	}
    
    
    
    
    
    
    
    
    
    
    
    /*
    public List<CursoAperturado> getCursosAperturados(Ciclo ciclo){
    	return generalDAO.getCursosAperturados(ciclo);
    }

    public Ciclo getCiclo(Integer anio, Integer periodo){  			
    	List<Ciclo> ciclo = generalDAO.getCiclo(anio, periodo);
    	if(ciclo != null && ciclo.size() > 0){
    		return ciclo.get(0);
    	}
    	return null;
    }
    
    public List<CursoTO> getCursos(String usuarioId) {
         List<Curso> cursos = generalDAO.getCursos(usuarioId);
         List<CursoTO> listaCursoTO = ConverterToTO.convertListaCursoTO(cursos);
         return listaCursoTO;
    }

	public List<CursoMatriculadoTO> getCursosMatriculados(String usuarioId) {
		return generalDAO.getCursosMatriculados(usuarioId);
	}

	public List<CursoAsignadoTO> getCursosAsignados(String usuarioId) {
		return generalDAO.getCursosAsignados(usuarioId);
	}

	public List<TipoTO> getTipos(String tabla_referencia) {
		return generalDAO.getTipos(tabla_referencia);
	}
    */
    
}
