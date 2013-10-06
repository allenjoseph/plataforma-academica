/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.business;

import com.platacad.dao.GeneralDAO;
import com.platacad.entities.Curso;
import com.platacad.helpers.ConverterToTO;
import com.platacad.to.CursoTO;
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

    public List<CursoTO> getCursos(String usuarioId) {
         List<Curso> cursos = generalDAO.getCursos(usuarioId);
         List<CursoTO> listaCursoTO = ConverterToTO.convertListaCursoTO(cursos);
         return listaCursoTO;
    }
    
    
}
