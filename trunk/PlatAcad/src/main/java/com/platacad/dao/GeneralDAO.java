/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.dao;

import com.platacad.entities.Curso;
import com.platacad.entities.Matricula;
import com.platacad.to.CursoAsignadoTO;
import com.platacad.to.CursoMatriculadoTO;
import com.platacad.to.TipoTO;

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
				+ "	(SELECT t.parametro FROM tipos t WHERE t.id_tipos_pk = c.tipo) AS \"tipo\","
				+ "	(SELECT CONCAT_WS(' ',u.nombres,u.apellido_paterno,u.apellido_materno) FROM usuario u WHERE u.id_usuario_pk = ca.id_docente_fk) AS \"docente\","
				+ "	(SELECT CAST(COUNT(*) AS DECIMAL) FROM articulo a WHERE a.id_curso_aperturado_fk = ca.id_curso_aperturado_pk) AS \"numero_articulos\","
				+ "	(SELECT CAST(COUNT(*) AS DECIMAL) FROM examen e WHERE e.id_curso_aperturado_fk = ca.id_curso_aperturado_pk) AS \"numero_examenes\","
				+ "	(SELECT CAST(COUNT(*) AS DECIMAL) FROM trabajo_encargado t WHERE t.id_curso_aperturado_fk = ca.id_curso_aperturado_pk) AS \"numero_trabajos\","
				+ " (SELECT a.modificacion_fecha FROM articulo a ORDER BY a.modificacion_fecha DESC LIMIT 0,1) AS \"actualizacion_articulos\","
				+ " (SELECT e.modificacion_fecha FROM examen e ORDER BY e.modificacion_fecha DESC LIMIT 0,1) AS \"actualizacion_examenes\","
				+ " (SELECT t.modificacion_fecha FROM trabajo_encargado t ORDER BY t.modificacion_fecha DESC LIMIT 0,1) AS \"actualizacion_trabajos\""
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

	public List<CursoAsignadoTO> getCursosAsignados(String usuarioId) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createSQLQuery("SELECT c.nombre AS \"nombre\","
				+ "	c.creditos AS \"creditos\","
				+ "	(SELECT t.parametro FROM tipos t WHERE t.id_tipos_pk = c.tipo) AS \"tipo\","
				+ "	(SELECT CAST(COUNT(*) AS DECIMAL) FROM matricula c WHERE c.id_curso_aperturado_fk = ca.id_curso_aperturado_pk) AS \"numero_alumnos\","
				+ "	(SELECT CAST(COUNT(*) AS DECIMAL) FROM articulo a WHERE a.id_curso_aperturado_fk = ca.id_curso_aperturado_pk) AS \"numero_articulos\","
				+ "	(SELECT CAST(COUNT(*) AS DECIMAL) FROM examen e WHERE e.id_curso_aperturado_fk = ca.id_curso_aperturado_pk) AS \"numero_examenes\","
				+ "	(SELECT CAST(COUNT(*) AS DECIMAL) FROM trabajo_encargado t WHERE t.id_curso_aperturado_fk = ca.id_curso_aperturado_pk) AS \"numero_trabajos\","
				+ " (SELECT a.modificacion_fecha FROM articulo a ORDER BY a.modificacion_fecha DESC LIMIT 0,1) AS \"actualizacion_articulos\","
				+ " (SELECT e.modificacion_fecha FROM examen e ORDER BY e.modificacion_fecha DESC LIMIT 0,1) AS \"actualizacion_examenes\","
				+ " (SELECT t.modificacion_fecha FROM trabajo_encargado t ORDER BY t.modificacion_fecha DESC LIMIT 0,1) AS \"actualizacion_trabajos\""
				+ " FROM curso_aperturado ca,"
				+ "	curso c"
				+ " WHERE c.id_curso_pk = ca.id_curso_fk"
				+ "	AND ca.id_ciclo_fk = 1"
				+ "	AND ca.id_docente_fk = ?")
				.setParameter(0, usuarioId)
				.setResultTransformer(Transformers.aliasToBean(CursoAsignadoTO.class));
		return query.list();
	}

	public List<TipoTO> getTipos(String tabla_referencia) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createSQLQuery("SELECT t.id_tipos_pk AS \"id\","
				+ "	t.parametro AS \"parametro\","
				+ "	t.descripcion AS \"descripcion\""
				+ " FROM tipos t"
				+ " WHERE t.tabla_referencia = ?")
				.setParameter(0, tabla_referencia)
				.setResultTransformer(Transformers.aliasToBean(TipoTO.class));
		return query.list();
	}
}
