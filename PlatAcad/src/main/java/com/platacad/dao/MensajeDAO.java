/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.dao;

import com.platacad.model.entities.Mensaje;
import com.platacad.to.MensajeTO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author PC
 */
@Repository
public class MensajeDAO {

	@PersistenceContext
	private EntityManager em;

	public boolean eliminarMensaje(int cod) {
		boolean b = false;
		try {
			Mensaje t = em.getReference(Mensaje.class, cod);
			em.remove(t);			
			b = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	public Mensaje BuscarMensaje(int cod) {
		Mensaje t = null;
		try {
			t = em.getReference(Mensaje.class, cod);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}

	public List<MensajeTO> getListaMensaje(String cod) {
		List<Mensaje> lista = em.createNativeQuery( "SELECT a.id_mensaje_pk ,a.asunto, a.mensaje,  b.nombres FROM mensaje a INNER JOIN usuario b ON b.id_usuario_pk = a.id_usuario_destino_fk where a.id_usuario_fk='"+ cod + "'").getResultList();
		List<MensajeTO> listaTO = new ArrayList<MensajeTO>();
		
		for(Mensaje m : lista){
			MensajeTO mTO = new MensajeTO();
			mTO.setAsunto(m.getAsunto());
			mTO.setId_mensaje_pk(m.getIdMensajePk());
			mTO.setMensaje(m.getMensaje());
			listaTO.add(mTO);
		}
		
		return null;
	}

}
