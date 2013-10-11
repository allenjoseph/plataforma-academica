/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.to;

import java.io.Serializable;
import java.util.Date;

import com.platacad.entities.Auditoria;

/**
 *
 * @author allen
 */
public class MensajeTO extends Auditoria implements Serializable{
    
	private String asunto;
    private String mensaje;
    private String usuarioRemitente;
    private String usuarioDestinatario;

    public MensajeTO() {
    }    
    
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getUsuarioRemitente() {
        return usuarioRemitente;
    }

    public void setUsuarioRemitente(String usuarioRemitente) {
        this.usuarioRemitente = usuarioRemitente;
    }

    public String getUsuarioDestinatario() {
        return usuarioDestinatario;
    }

    public void setUsuarioDestinatario(String usuarioDestinatario) {
        this.usuarioDestinatario = usuarioDestinatario;
    }

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}   
    
}
