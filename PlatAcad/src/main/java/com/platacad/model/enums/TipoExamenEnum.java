package com.platacad.model.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum TipoExamenEnum {

    PRACTICA_CALIFICADA(Integer.valueOf(5), "PRACTICA CALIFICADA"),
    
    PRACTICA_RECUPERACION(Integer.valueOf(6), "PRACTICA DE RECUPERACION"),
    
    PASO_ORAL(Integer.valueOf(7), "PASO ORAL"),
    
    EXAMEN_PARCIAL(Integer.valueOf(8), "EXAMEN PARCIAL"),
    
    EXAMEN_FINAL(Integer.valueOf(9), "EXAMEN FINAL");
    
    private final Integer codigo;
	
    private final String descripcion;
    
    public final static List<TipoExamenEnum> list=new ArrayList<TipoExamenEnum>();

	public final static Map<Integer, TipoExamenEnum> lookup=new HashMap<Integer, TipoExamenEnum>();

	static {
		for(TipoExamenEnum c : TipoExamenEnum.values()){
			lookup.put(c.getCodigo(), c);
			list.add( c );
		}
	}
    
    private TipoExamenEnum(Integer codigo, String descripcion) {   
         this.codigo = codigo;
         this.descripcion = descripcion;
    }

    public Integer getCodigo() {
		return codigo;
	}

	public String getDescripcion() {
        return descripcion;
    }  
	
	public static TipoExamenEnum get(Integer codigo) {
		return lookup.get(codigo);
	}
}
