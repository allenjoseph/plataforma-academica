/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.services;

import java.util.Date;
import java.util.List;

import com.platacad.model.entities.Usuario;
import com.platacad.to.UsuarioTO;

/**
 *
 * @author allen
 */
public interface UsuarioServiceInterface {
    
    public Usuario getUsuario(String usuarioId);
    
    public Usuario buscarUsuario(String usuarioId);
    
    public Integer getTotalMensajes(String usuarioId, Integer estado);
    
    public Integer getTotalExamenes(String usuarioId, Date fecha);
    
    public Integer getTotalTrabajos(String usuarioId, Integer estado);
    
    public List<UsuarioTO> getUsuarios(String text);
}
