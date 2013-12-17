/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.services;

import com.platacad.model.entities.Usuario;
import com.platacad.to.UsuarioTO;

/**
 *
 * @author allen
 */
public interface UsuarioServiceInterface {
    
    public Usuario getUsuario(String usuarioId);
    
     public Usuario buscarUsuario(String usuarioId);
}
