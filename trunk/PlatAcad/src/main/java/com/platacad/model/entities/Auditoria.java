package com.platacad.model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.platacad.model.commons.UserInfo;

@Embeddable
public class Auditoria implements Serializable{
	
	@Basic(optional = false)
	@Column(name = "creacion_fecha")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creacionFecha;
	
	@Basic(optional = false)
	@Column(name = "creacion_usuario")
	private String creacionUsuario;
	
	@Basic(optional = false)
	@Column(name = "modificacion_fecha", insertable = false, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date modificacionFecha;
	
	@Basic(optional = false)
	@Column(name = "modificacion_usuario", nullable = false, length = 10)
	private String modificacionUsuario;
		
	public Auditoria() {
		// TODO Auto-generated constructor stub
	}

	public Date getCreacionFecha() {
		return creacionFecha;
	}

	public void setCreacionFecha(Date creacionFecha) {
		this.creacionFecha = creacionFecha;
	}

	public String getCreacionUsuario() {
		return creacionUsuario;
	}

	public void setCreacionUsuario(String creacionUsuario) {
		this.creacionUsuario = creacionUsuario;
	}

	public Date getModificacionFecha() {
		return modificacionFecha;
	}

	public void setModificacionFecha(Date modificacionFecha) {
		this.modificacionFecha = modificacionFecha;
	}

	public String getModificacionUsuario() {
		return modificacionUsuario;
	}

	public void setModificacionUsuario(String modificacionUsuario) {
		this.modificacionUsuario = modificacionUsuario;
	}
	
	public void prePresist(){
		setCreacionFecha(new Date());
		setModificacionFecha(new Date());
		setCreacionUsuario(UserInfo.userId);
		setModificacionUsuario(UserInfo.userId);
	}
	
	public void preUpdate() {
		setModificacionFecha(new Date());
		setModificacionUsuario(UserInfo.userId);		
	}

}
