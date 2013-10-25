/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.services;

import com.platacad.business.GeneralBusiness;
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
    
}
