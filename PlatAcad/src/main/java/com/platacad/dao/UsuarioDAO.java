/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.platacad.entities.Usuario;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author allen
 */
@Repository
public class UsuarioDAO {

	@PersistenceContext
	private EntityManager em;
    
	@Transactional
    public Usuario getUsuario(String usuarioId) {
        return em.getReference(Usuario.class, usuarioId);
    }
    
}
