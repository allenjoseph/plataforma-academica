package com.platacad.model.entities;

import java.io.Serializable;
import java.util.Date;

public class Evento implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer idEventoPk;
	
	private Date fechaEvento;
	
	private String titulo;
	
	private String descripcion;
	
	public Evento() {}

	public Integer getIdEventoPk() {
		return idEventoPk;
	}

	public void setIdEventoPk(Integer idEventoPk) {
		this.idEventoPk = idEventoPk;
	}

	public Date getFechaEvento() {
		return fechaEvento;
	}

	public void setFechaEvento(Date fechaEvento) {
		this.fechaEvento = fechaEvento;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
