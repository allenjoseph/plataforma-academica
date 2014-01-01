package com.platacad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platacad.business.MensajeBusiness;
import com.platacad.model.entities.Mensaje;
import com.platacad.to.MensajeTO;
import com.platacad.to.UsuarioTO;

import java.util.List;

@Service
public class MensajeService implements MensajeServiceInterface{
	
	@Autowired
	private MensajeBusiness mensajeBusiness;

	public boolean enviarMensaje(Mensaje mensaje) {
		return mensajeBusiness.insertarActualizaMensaje(mensaje);
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
