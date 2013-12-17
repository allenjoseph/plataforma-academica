/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.services;

import com.platacad.model.entities.Ciclo;
import com.platacad.model.entities.CursoAperturado;
import com.platacad.model.entities.Matricula;
import com.platacad.model.entities.Usuario;
import com.platacad.model.enums.TipoPeriodoEnum;
import com.platacad.to.CursoMatriculadoTO;
import com.platacad.to.CursoTO;

import java.util.List;

/**
 *
 * @author allen
 */
public interface GeneralServiceInterface {
    
    public List<Matricula> getCursosMatriculados(Integer ciclo, String usuario);
    
    public List<CursoMatriculadoTO> getCursosMatriculadosTO(Integer ciclo, String usuario);
	/*
	public List<CursoTO> getCursos(String usuarioId);
    public List<CursoMatriculadoTO> getCursosMatriculados(String usuarioId);
    public Ciclo getCiclo(Integer anio, Integer periodo);
    public List<CursoAperturado> getCursosAperturados(Ciclo ciclo);
	 */
}
