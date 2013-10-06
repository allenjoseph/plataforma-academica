/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.dao;

import com.platacad.entities.Curso;
import com.platacad.entities.Matricula;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author allen
 */
@Repository
public class GeneralDAO extends HibernateDaoSupport {

    @Autowired
    public GeneralDAO(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public List<Curso> getCursos(String usuarioId) {
        List<Matricula> matriculas = getSession().createCriteria(Matricula.class)
                .add(Restrictions.eq("idUsuarioFk.idUsuarioPk", usuarioId))
                .list();
        
        List idcursos = new ArrayList<Integer>();
        for(Matricula m : matriculas){
            idcursos.add(m.getIdCursoFk().getIdCursoPk());
        }

        List cursos = getSession().createCriteria(Curso.class)
                .add(Property.forName("idCursoPk").in(idcursos))
                .list();

        return cursos;
    }
}
