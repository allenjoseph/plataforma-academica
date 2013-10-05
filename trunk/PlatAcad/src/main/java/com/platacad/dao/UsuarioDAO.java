/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.dao;

import com.platacad.entities.Usuario;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author allen
 */
@Repository
public class UsuarioDAO extends HibernateDaoSupport{

    @Autowired
    public UsuarioDAO(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
    
    public Usuario getUsuario(String usuarioId) {
        return getHibernateTemplate().get(Usuario.class, usuarioId);
    }
    
}
