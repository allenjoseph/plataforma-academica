/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.services;

import com.platacad.entities.Usuario;
import com.platacad.to.UsuarioTO;

/**
 *
 * @author allen
 */
public interface UsuarioServiceInterface {
    
    public UsuarioTO getUsuario(String usuarioId);
    
     public Usuario buscarUsuario(String usuarioId);
}
