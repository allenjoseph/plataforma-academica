package com.platacad.entities;

import java.util.Date;

public class Auditoria {

	private String usuarioAuditoria;
	private Date fechaAuditoria;
	
	public Auditoria() {
		// TODO Auto-generated constructor stub
	}

	public String getUsuarioAuditoria() {
		return usuarioAuditoria;
	}

	public void setUsuarioAuditoria(String usuarioAuditoria) {
		this.usuarioAuditoria = usuarioAuditoria;
	}

	public Date getFechaAuditoria() {
		return fechaAuditoria;
	}

	public void setFechaAuditoria(Date fechaAuditoria) {
		this.fechaAuditoria = fechaAuditoria;
	}
	
}
