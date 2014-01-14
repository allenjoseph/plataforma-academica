package com.platacad.business;

import com.platacad.dao.MensajeDAO;

import org.springframework.stereotype.Component;

import com.platacad.model.entities.Mensaje;
import com.platacad.model.entities.Usuario;
import com.platacad.repositories.MensajeRepository;
import com.platacad.to.MensajeTO;
import com.platacad.to.UsuarioTO;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

@Component
public class MensajeBusiness {

    @Autowired
    MensajeDAO mensajeDAO;

    @Resource
    MensajeRepository mensajeRepository;
    
   public Mensaje enviarMensaje(Mensaje mensaje) {
       return mensajeRepository.save(mensaje);
   }
   
   
   
   
   
   
    public boolean eliminarMensaje(int cod) {
        return mensajeDAO.eliminarMensaje(cod);
    }
    
    public Mensaje BuscarMensaje(int cod) {
        return mensajeDAO.BuscarMensaje(cod);
    }
    
    public List<MensajeTO> getListaMensaje(String cod) {
        return mensajeDAO.getListaMensaje(cod);
    }

	public List<Mensaje> obtenerMensajes(Usuario user) {		
		return mensajeRepository.findByIdUsuarioDestinoFk(user);
	}

}
