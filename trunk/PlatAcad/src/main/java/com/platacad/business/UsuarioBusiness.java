/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.business;

import com.platacad.dao.UsuarioDAO;
import com.platacad.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author allen
 */
@Component
public class UsuarioBusiness {
    
    @Autowired
    UsuarioDAO usuarioDAO;

    public Usuario getUsuario(String usuarioId) {
        return usuarioDAO.getUsuario(usuarioId);
    }
    
    public Usuario buscarUsuario(String usuarioId) {
        return usuarioDAO.getUsuario(usuarioId);
    } 
    
}
