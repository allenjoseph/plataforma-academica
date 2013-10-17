package com.platacad.to;

import java.math.BigInteger;

public class CursoMatriculadoTO {
	private String nombre;
	private Integer creditos;
	private String tipo;
	private String docente;
	private long numero_articulos;
	private long numero_examenes;
	private long numero_trabajos;
	
	public CursoMatriculadoTO() {
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCreditos() {
		return creditos;
	}

	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDocente() {
		return docente;
	}

	public void setDocente(String docente) {
		this.docente = docente;
	}

	public long getNumero_articulos() {
		return numero_articulos;
	}

	public void setNumero_articulos(long numero_articulos) {
		this.numero_articulos = numero_articulos;
	}

	public long getNumero_examenes() {
		return numero_examenes;
	}

	public void setNumero_examenes(long numero_examenes) {
		this.numero_examenes = numero_examenes;
	}

	public long getNumero_trabajos() {
		return numero_trabajos;
	}

	public void setNumero_trabajos(long numero_trabajos) {
		this.numero_trabajos = numero_trabajos;
	}

	
}
