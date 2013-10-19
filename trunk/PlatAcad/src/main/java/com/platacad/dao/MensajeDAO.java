/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.dao;

import com.platacad.entities.Mensaje;
import com.platacad.to.MensajeTO;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PC
 */
@Repository
public class MensajeDAO extends HibernateDaoSupport{
    
    @Autowired
    public MensajeDAO(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
    
 
    public boolean insertarActualizaMensaje(Mensaje t) {
         boolean b=false;
        try{
            getHibernateTemplate().saveOrUpdate(t);
            b=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return b;
    }
    
   
    public boolean eliminarMensaje(int cod) {
         boolean b=false;
        try{
            Mensaje t = getHibernateTemplate().get(Mensaje.class, cod);
            getHibernateTemplate().delete(t);
            b=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return b;
    }
     
    
    public Mensaje BuscarMensaje(int cod) {
         Mensaje t = null;
        try{
            t = getHibernateTemplate().get(Mensaje.class, cod);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return t;
    }
    
   

 
    public List<MensajeTO> getListaMensaje(String cod) {
          Session session = getHibernateTemplate().getSessionFactory()
				.openSession();
		Query consulta = session
				.createSQLQuery(
						"SELECT a.id_mensaje_pk ,a.asunto, a.mensaje,  b.nombres FROM mensaje a "
                        + "INNER JOIN usuario b ON b.id_usuario_pk = a.id_usuario_destino_fk where a.id_usuario_fk='"+cod+"'")
				.setResultTransformer(Transformers.aliasToBean(MensajeTO.class));
                return consulta.list();
    }
    
    
}