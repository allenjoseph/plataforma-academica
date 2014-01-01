package com.platacad.model.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum EstadoEntidad {
	
	ACTIVO(Integer.valueOf(1), "ACTIVO"),

	BLOQUEADO(Integer.valueOf(2), "BLOQUEADO"),
	
	FINALIZADO(Integer.valueOf(3), "FINALIZADO"),
	
	INACTIVO(Integer.valueOf(4), "INACTIVO");

	private final Integer codigo;

	private final String descripcion;

	public final static List<EstadoEntidad> list = new ArrayList<EstadoEntidad>();

	public final static Map<Integer, EstadoEntidad> lookup = new HashMap<Integer, EstadoEntidad>();

	static {
		for (EstadoEntidad c : EstadoEntidad.values()) {
			lookup.put(c.getCodigo(), c);
			list.add(c);
		}
	}

	private EstadoEntidad(Integer codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public static EstadoEntidad get(Integer codigo) {
		return lookup.get(codigo);
	}
}
