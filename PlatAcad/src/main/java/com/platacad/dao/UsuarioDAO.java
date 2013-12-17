/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.dao;

import javax.annotation.Resource;

import com.platacad.helpers.KeyWords;
import com.platacad.model.entities.Usuario;
import com.platacad.repositories.UsuarioRepository;

import org.springframework.stereotype.Repository;

/**
 *
 * @author allen
 */
@Repository
public class UsuarioDAO {

	@Resource
	private UsuarioRepository usuarioRepository;
    
    public Usuario getUsuario(String usuarioId) {
    	Usuario user = usuarioRepository.findOne(usuarioId);
    	user.setFullName(user.getNombres().concat(KeyWords.BLANK_SPACE)
						.concat(user.getApellidoPaterno()).concat(KeyWords.BLANK_SPACE)
						.concat(user.getApellidoMaterno()));
        return user;
    }
    
}
