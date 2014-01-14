/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.services;

import com.platacad.model.entities.CursoAperturado;
import com.platacad.model.entities.Matricula;
import com.platacad.model.entities.Usuario;
import com.platacad.to.CursoMatriculadoTO;
import com.platacad.to.TimelineItemTO;

import java.util.List;

/**
 *
 * @author allen
 */
public interface GeneralServiceInterface {
    
    public List<Matricula> getCursosMatriculados(Integer ciclo, String usuario);
    
    public List<CursoMatriculadoTO> getCursosMatriculadosTO(Integer ciclo, String usuario);
    
    public List<CursoAperturado> getCursosACargo(Integer ciclo, String usuario);

	public List<TimelineItemTO> getTimeline(Usuario user);

}
