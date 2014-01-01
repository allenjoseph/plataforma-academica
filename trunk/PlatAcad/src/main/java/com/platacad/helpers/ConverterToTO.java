/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.helpers;

import com.platacad.model.entities.Curso;
import com.platacad.model.entities.Usuario;
import com.platacad.to.CursoTO;
import com.platacad.to.UsuarioTO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author allen
 */
public class ConverterToTO {
    
    public static UsuarioTO convertToUsuarioTO(Usuario user){
        UsuarioTO to = new UsuarioTO();
        return to;
    }

    public static List<CursoTO> convertListaCursoTO(List<Curso> cursos) {
        List<CursoTO> listaCursoTO = new ArrayList<CursoTO>();
        return listaCursoTO;
    }
}
