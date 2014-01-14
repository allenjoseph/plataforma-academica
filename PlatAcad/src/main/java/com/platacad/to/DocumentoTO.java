package com.platacad.to;

import java.io.Serializable;

public class DocumentoTO implements Serializable {

	private Integer id;
	
	private String titulo;
	
	private Integer idArchivo;
	
	public DocumentoTO(){
	}

	public DocumentoTO(Integer id,String titulo,Integer idArchivo){
		this.id = id;
		this.titulo = titulo;
		this.idArchivo = idArchivo;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getIdArchivo() {
		return idArchivo;
	}

	public void setIdArchivo(Integer idArchivo) {
		this.idArchivo = idArchivo;
	}
}
