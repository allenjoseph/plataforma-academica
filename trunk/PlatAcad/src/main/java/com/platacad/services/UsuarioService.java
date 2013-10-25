/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.services;

import com.platacad.business.UsuarioBusiness;
import com.platacad.entities.Usuario;
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

    public Usuario getUsuario(String usuarioId) {
        return usuarioBussiness.getUsuario(usuarioId);
    }
    
    public Usuario buscarUsuario(String usuarioId) {
        return usuarioBussiness.buscarUsuario(usuarioId);
    }
    
}
