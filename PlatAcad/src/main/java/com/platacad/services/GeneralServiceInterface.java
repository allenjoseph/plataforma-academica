/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.services;

import com.platacad.entities.Ciclo;
import com.platacad.entities.CursoAperturado;
import com.platacad.entities.Matricula;
import com.platacad.entities.Usuario;
import com.platacad.entities.enums.TipoPeriodoEnum;
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
