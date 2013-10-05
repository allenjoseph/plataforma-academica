/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.services;

import com.platacad.business.UsuarioBusiness;
import com.platacad.to.UsuarioTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author allen
 */
@Service
public class UsuarioService implements UsuarioServiceInterface{
    
    @Autowired
    UsuarioBusiness usuarioBussiness;

    public UsuarioTO getUsuario(String usuarioId) {
        return usuarioBussiness.getUsuario(usuarioId);
    }
    
}
