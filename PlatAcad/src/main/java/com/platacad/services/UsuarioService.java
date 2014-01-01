/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.services;

import java.util.Date;
import java.util.List;

import com.platacad.business.UsuarioBusiness;
import com.platacad.model.entities.Usuario;
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
    
    public Integer getTotalMensajes(String usuarioId, Integer estado){
    	return usuarioBussiness.getTotalMensajes(usuarioId, estado);
    }
    
    public Integer getTotalExamenes(String usuarioId, Date fecha){
    	return usuarioBussiness.getTotalExamenes(usuarioId, fecha);
    }
    
    public Integer getTotalTrabajos(String usuarioId, Integer estado){
    	return usuarioBussiness.getTotalTrabajos(usuarioId, estado);
    }
    
	public List<UsuarioTO> getUsuarios(String text) {
		return usuarioBussiness.getUsuarios(text);
	}
}
