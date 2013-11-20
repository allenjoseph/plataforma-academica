/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.services;

import com.platacad.business.GeneralBusiness;
import com.platacad.entities.Ciclo;
import com.platacad.entities.CursoAperturado;
import com.platacad.entities.Matricula;
import com.platacad.entities.Usuario;
import com.platacad.enums.TipoPeriodoEnum;
import com.platacad.to.CursoAsignadoTO;
import com.platacad.to.CursoMatriculadoTO;
import com.platacad.to.CursoTO;
import com.platacad.to.TipoTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author allen
 */
@Service
public class GeneralService implements GeneralServiceInterface{

    @Autowired
    GeneralBusiness generalBusiness;
    
    public List<CursoTO> getCursos(String usuarioId) {                   
        return generalBusiness.getCursos(usuarioId);
    }

	public List<CursoMatriculadoTO> getCursosMatriculados(String usuarioId) {
		return generalBusiness.getCursosMatriculados(usuarioId);
	}

	public List<CursoAsignadoTO>  getCursosAsignados(String usuarioId) {
		return generalBusiness.getCursosAsignados(usuarioId);
	}

	public List<TipoTO> getTipos(String tabla_referencia) {		
		return generalBusiness.getTipos(tabla_referencia);
	}

	public Ciclo getCiclo(Integer anio, TipoPeriodoEnum periodo) {		
		return generalBusiness.getCiclo(anio, periodo);
	}

	public List<CursoAperturado> getCursosAperturados(Ciclo ciclo) {		
		return generalBusiness.getCursosAperturados(ciclo);
	}
	
	public List<Matricula> getCursosMatriculados(Ciclo ciclo, Usuario usuario){
		return generalBusiness.getCursosMatriculados(ciclo, usuario);
	}
    
}
