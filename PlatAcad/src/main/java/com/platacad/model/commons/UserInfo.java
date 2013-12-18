package com.platacad.model.commons;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.platacad.model.entities.Usuario;

@Component
public class UserInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Usuario user;
	
	private Date inicioSesion;
	
	private Date finSession;
	
	private List<String> enlacesVisitados;
	
	public UserInfo() {
		user = new Usuario();
		enlacesVisitados = new ArrayList<String>();
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public Date getInicioSesion() {
		return inicioSesion;
	}

	public void setInicioSesion(Date inicioSesion) {
		this.inicioSesion = inicioSesion;
	}

	public Date getFinSession() {
		return finSession;
	}

	public void setFinSession(Date finSession) {
		this.finSession = finSession;
	}

	public List<String> getEnlacesVisitados() {
		return enlacesVisitados;
	}

	public void setEnlacesVisitados(List<String> enlacesVisitados) {
		this.enlacesVisitados = enlacesVisitados;
	}

	public void closeSession() {
		// se persiste todo el tracking de la aplicacion para la auditoria
		
		this.setUser(new Usuario());
		this.setEnlacesVisitados(new ArrayList<String>());
	}
}
