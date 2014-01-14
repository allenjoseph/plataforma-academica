package com.platacad.to;

import java.io.Serializable;
import java.util.Date;

public class TimelineItemTO implements Serializable{
	
	private Date fecha;
	
	private String titulo;
	
	private String referencia;
	
	public TimelineItemTO(){
		
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
}
