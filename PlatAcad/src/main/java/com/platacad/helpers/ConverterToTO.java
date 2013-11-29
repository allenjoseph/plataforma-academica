/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.helpers;

import com.platacad.entities.Curso;
import com.platacad.entities.Usuario;
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
        to.setCodigo(user.getIdUsuarioPk());
        to.setNombre(user.getNombres());
        to.setNombreCompleto(user.getNombres().concat(" ").concat(user.getApellidoPaterno()).concat(" ").concat(user.getApellidoPaterno()));
        return to;
    }

    public static List<CursoTO> convertListaCursoTO(List<Curso> cursos) {
        List<CursoTO> listaCursoTO = new ArrayList<CursoTO>();        
        /*for(Curso c : cursos){
            CursoTO cursoTO = new CursoTO();
            cursoTO.setNombre(c.getNombre());
            cursoTO.setCreditos(c.getCreditos());
            cursoTO.setTipo(TipoCursoEnum.obtenerEnum(c.getTipo().getIdTiposPk()));
            listaCursoTO.add(cursoTO);
        }*/
        return listaCursoTO;
    }
}
