package com.platacad.model.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum TipoRolEnum {

	ADMIN(Integer.valueOf(10), "ADMINISTRATIVO"),
    
    DOCENTE(Integer.valueOf(11), "DOCENTE"),
    
    ALUMNO(Integer.valueOf(12), "ALUMNO");
    
    private final Integer codigo;
	
    private final String descripcion;
    
    public final static List<TipoRolEnum> list=new ArrayList<TipoRolEnum>();

	public final static Map<Integer, TipoRolEnum> lookup=new HashMap<Integer, TipoRolEnum>();

	static {
		for(TipoRolEnum c : TipoRolEnum.values()){
			lookup.put(c.getCodigo(), c);
			list.add( c );
		}
	}
    
    private TipoRolEnum(Integer codigo, String descripcion) {   
         this.codigo = codigo;
         this.descripcion = descripcion;
    }

    public Integer getCodigo() {
		return codigo;
	}

	public String getDescripcion() {
        return descripcion;
    }  
	
	public static TipoRolEnum get(Integer codigo) {
		return lookup.get(codigo);
	}
}
