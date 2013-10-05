/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.services;

import com.platacad.to.CursoTO;
import java.util.List;

/**
 *
 * @author allen
 */
public interface GeneralServiceInterface {
    
    public List<CursoTO> getCursos(String usuarioId);
}
