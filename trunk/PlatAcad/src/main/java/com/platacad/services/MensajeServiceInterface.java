package com.platacad.services;

import com.platacad.entities.Mensaje;
import com.platacad.to.MensajeTO;
import java.util.List;

public interface MensajeServiceInterface {
	
	public boolean enviarMensaje(Mensaje mensaje);

        public boolean eliminarMensaje(int cod) ;
        
        public Mensaje buscarMensaje(int cod) ;
        
        public List<MensajeTO> listarMensaje(String cod);
}
