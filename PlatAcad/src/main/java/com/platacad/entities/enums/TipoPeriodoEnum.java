package com.platacad.entities.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum TipoPeriodoEnum {
	
	IMPAR(Integer.valueOf(3),"PERIODO I"),
	
	PAR(Integer.valueOf(4),"PERIODO II");
	
	private final Integer code;
	
    private final String descripcion;
    
    public final static List<TipoPeriodoEnum> list=new ArrayList<TipoPeriodoEnum>();

	public final static Map<Integer, TipoPeriodoEnum> lookup=new HashMap<Integer, TipoPeriodoEnum>();

	static {
		for(TipoPeriodoEnum c : TipoPeriodoEnum.values()){
			lookup.put(c.getCode(), c);
			list.add( c );
		}
	}
    
    private TipoPeriodoEnum(Integer code, String descripcion) {   
         this.code = code;
         this.descripcion = descripcion;
    }

    public Integer getCode() {
		return code;
	}

	public String getDescripcion() {
        return descripcion;
    }  
	
	public static TipoPeriodoEnum get(Integer code) {
		return lookup.get(code);
	}
 
}
