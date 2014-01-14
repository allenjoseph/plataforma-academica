package com.platacad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platacad.business.MensajeBusiness;
import com.platacad.model.entities.Mensaje;
import com.platacad.model.entities.Usuario;
import com.platacad.to.MensajeTO;
import com.platacad.to.UsuarioTO;

import java.util.List;

@Service
public class MensajeService implements MensajeServiceInterface{
	
	@Autowired
	private MensajeBusiness mensajeBusiness;

	public Mensaje enviarMensaje(Mensaje mensaje) {
		return mensajeBusiness.enviarMensaje(mensaje);
	}
	
	public List<Mensaje> obtenerMensajes(Usuario user) {
		return mensajeBusiness.obtenerMensajes(user);
	} 
	
	
	
	
	
	
	
        
        public boolean eliminarMensaje(int cod) {
		return mensajeBusiness.eliminarMensaje(cod);
	}
        
        public Mensaje buscarMensaje(int cod) {
		return mensajeBusiness.BuscarMensaje(cod);
	}
        
        public List<MensajeTO> listarMensaje(String cod) {
		return mensajeBusiness.getListaMensaje(cod);
	}

	 

}
