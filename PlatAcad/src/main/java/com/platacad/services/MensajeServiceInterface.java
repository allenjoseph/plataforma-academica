package com.platacad.services;

import com.platacad.model.entities.Mensaje;
import com.platacad.model.entities.Usuario;
import com.platacad.to.MensajeTO;

import java.util.List;

public interface MensajeServiceInterface {
	
	public Mensaje enviarMensaje(Mensaje mensaje);
	
	public List<Mensaje> obtenerMensajes(Usuario user);
	
	
	

        public boolean eliminarMensaje(int cod) ;
        
        public Mensaje buscarMensaje(int cod) ;
        
        public List<MensajeTO> listarMensaje(String cod);

		
}
