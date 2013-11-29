package com.platacad.to;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class CursoMatriculadoTO {
	
	private String nombre;
	
	private Integer creditos;
	
	private String tipo;
	
	private String docente;
	
	private BigDecimal numero_articulos;
	
	private BigDecimal numero_examenes;
	
	private BigDecimal numero_trabajos;
	
	private String fecha_actualizacion;
	
	private Timestamp actualizacion_articulos;
	
	private Timestamp actualizacion_examenes;
	
	private Timestamp actualizacion_trabajos;
	
	
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
		fecha_actualizacion = (new Date()).toString();
		if(actualizacion_articulos != null && actualizacion_examenes != null 
				&& actualizacion_examenes != null){
			if(actualizacion_articulos.compareTo(actualizacion_examenes) > 0 &&
				actualizacion_articulos.compareTo(actualizacion_trabajos) > 0){
				fecha_actualizacion = actualizacion_articulos.toString();
			}else if(actualizacion_examenes.compareTo(actualizacion_trabajos)>0){
				fecha_actualizacion = actualizacion_examenes.toString();
			}else{
				fecha_actualizacion = actualizacion_trabajos.toString();
			}
		}
		
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
