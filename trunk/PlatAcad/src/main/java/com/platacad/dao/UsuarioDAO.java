/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.dao;

import javax.annotation.Resource;

import com.platacad.entities.Usuario;
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
        return usuarioRepository.findOne(usuarioId);
    }
    
}
