package com.platacad.to;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class CursoAsignadoTO {
	private String nombre;
	private Integer creditos;
	private String tipo;
	private BigDecimal numero_alumnos;
	private BigDecimal numero_articulos;
	private BigDecimal numero_examenes;
	private BigDecimal numero_trabajos;
	private String fecha_actualizacion;
	
	private Timestamp actualizacion_articulos;
	private Timestamp actualizacion_examenes;
	private Timestamp actualizacion_trabajos;
	
	public CursoAsignadoTO() {
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

	public BigDecimal getNumero_alumnos() {
		return numero_alumnos;
	}

	public void setNumero_alumnos(BigDecimal numero_alumnos) {
		this.numero_alumnos = numero_alumnos;
	}

	public BigDecimal getNumero_articulos() {
		return numero_articulos;
	}

	public void setNumero_articulos(BigDecimal numero_articulos) {
		this.numero_articulos = numero_articulos;
	}

	public BigDecimal getNumero_examenes() {
		return numero_examenes;
	}

	public void setNumero_examenes(BigDecimal numero_examenes) {
		this.numero_examenes = numero_examenes;
	}

	public BigDecimal getNumero_trabajos() {
		return numero_trabajos;
	}

	public void setNumero_trabajos(BigDecimal numero_trabajos) {
		this.numero_trabajos = numero_trabajos;
	}

	public String getFecha_actualizacion() {
		return fecha_actualizacion;
	}

	public void setFecha_actualizacion(String fecha_actualizacion) {
		this.fecha_actualizacion = fecha_actualizacion;
	}

	public Timestamp getActualizacion_articulos() {
		return actualizacion_articulos;
	}

	public void setActualizacion_articulos(Timestamp actualizacion_articulos) {
		this.actualizacion_articulos = actualizacion_articulos;
	}

	public Timestamp getActualizacion_examenes() {
		return actualizacion_examenes;
	}

	public void setActualizacion_examenes(Timestamp actualizacion_examenes) {
		this.actualizacion_examenes = actualizacion_examenes;
	}

	public Timestamp getActualizacion_trabajos() {
		return actualizacion_trabajos;
	}

	public void setActualizacion_trabajos(Timestamp actualizacion_trabajos) {
		this.actualizacion_trabajos = actualizacion_trabajos;
	}
	
	
}
