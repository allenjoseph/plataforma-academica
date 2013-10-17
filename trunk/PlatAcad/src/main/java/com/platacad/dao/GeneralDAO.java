/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.dao;

import com.platacad.entities.Curso;
import com.platacad.entities.Matricula;
import com.platacad.to.CursoMatriculadoTO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
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
        return null;
    }

	public List<CursoMatriculadoTO> getCursosMatriculados(String usuarioId) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createSQLQuery("SELECT c.nombre AS \"nombre\","
				+ "	c.creditos AS \"creditos\","
				+ "	(SELECT t.descripcion FROM tipos t WHERE t.id_tipos_pk = c.tipo) AS \"tipo\","
				+ "	(SELECT CONCAT_WS(' ',u.nombres,u.apellido_paterno,u.apellido_materno) FROM usuario u WHERE u.id_usuario_pk = ca.id_docente_fk) AS \"docente\","
				+ "	(SELECT COUNT(*) FROM articulo a WHERE a.id_curso_aperturado_fk = ca.id_curso_aperturado_pk) AS \"numero_articulos\","
				+ "	(SELECT COUNT(*) FROM examen e WHERE e.id_curso_aperturado_fk = ca.id_curso_aperturado_pk) AS \"numero_examenes\","
				+ "	(SELECT COUNT(*) FROM trabajo_encargado t WHERE t.id_curso_aperturado_fk = ca.id_curso_aperturado_pk) AS \"numero_trabajos\""
				+ " FROM matricula m,"
				+ "	curso_aperturado ca,"
				+ "	curso c"
				+ " WHERE m.id_curso_aperturado_fk = ca.id_curso_aperturado_pk"
				+ "	AND c.id_curso_pk = ca.id_curso_fk"
				+ "	AND ca.id_ciclo_fk = 1"
				+ "	AND m.id_usuario_fk = ?")
				.setParameter(0, usuarioId)
				.setResultTransformer(Transformers.aliasToBean(CursoMatriculadoTO.class));
		return query.list();
	}
}
