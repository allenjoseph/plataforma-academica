/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.to;

import java.io.Serializable;
import java.util.Date;

import com.platacad.model.entities.Auditoria;

/**
 *
 * @author allen
 */
public class MensajeTO extends Auditoria implements Serializable{
    
	
    private Integer id_mensaje_pk;
    private String asunto;
    private String mensaje;
   private String nombres;

    public MensajeTO() {
    }

    public Integer getId_mensaje_pk() {
        return id_mensaje_pk;
    }

    public void setId_mensaje_pk(Integer id_mensaje_pk) {
        this.id_mensaje_pk = id_mensaje_pk;
    }

    
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}   
    
}
