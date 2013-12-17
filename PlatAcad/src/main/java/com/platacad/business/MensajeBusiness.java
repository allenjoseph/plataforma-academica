package com.platacad.business;

import com.platacad.dao.MensajeDAO;

import org.springframework.stereotype.Component;

import com.platacad.model.entities.Mensaje;
import com.platacad.to.MensajeTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Component
public class MensajeBusiness {

    @Autowired
    MensajeDAO mensajeDAO;

   public boolean insertarActualizaMensaje(Mensaje t) {
       return mensajeDAO.insertarActualizaMensaje(t);
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

}
