/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javassist.compiler.ast.Keyword;

import javax.annotation.Resource;

import com.platacad.dao.UsuarioDAO;
import com.platacad.helpers.KeyWords;
import com.platacad.model.entities.Usuario;
import com.platacad.repositories.UsuarioRepository;
import com.platacad.to.UsuarioTO;

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
    
    @Resource
	private UsuarioRepository usuarioRepository;

    public Usuario getUsuario(String usuarioId) {
        return usuarioDAO.getUsuario(usuarioId);
    }
    
    public Usuario buscarUsuario(String usuarioId) {
        return usuarioDAO.getUsuario(usuarioId);
    }

	public Integer getTotalMensajes(String usuarioId, Integer estado) {
		return usuarioRepository.getTotalMensajes(usuarioId, estado);
	}

	public Integer getTotalExamenes(String usuarioId, Date fecha) {		
		return usuarioRepository.getTotalExamenes(usuarioId, fecha);
	}

	public Integer getTotalTrabajos(String usuarioId, Integer estado) {
		return usuarioRepository.getTotalTrabajos(usuarioId, estado);
	} 
	
	public List<UsuarioTO> getUsuarios(String text) {
		List<Usuario> usuarios = usuarioRepository.getUsuarios(text);
		List<UsuarioTO> usuariosTO = new ArrayList<UsuarioTO>();
		for (Usuario usuario : usuarios) {
			usuariosTO.add(new UsuarioTO(usuario.getIdUsuarioPk(),usuario.getFullName()));
		}
		return usuariosTO;
	}
    
}
