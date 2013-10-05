/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.services;

import com.platacad.business.GeneralBusiness;
import com.platacad.to.CursoTO;
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
    
}
