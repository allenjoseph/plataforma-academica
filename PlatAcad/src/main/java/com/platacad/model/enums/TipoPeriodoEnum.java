package com.platacad.model.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum TipoPeriodoEnum {
	
	IMPAR(Integer.valueOf(1),"PERIODO I"),
	
	PAR(Integer.valueOf(2),"PERIODO II");
	
	private final Integer codigo;
	
    private final String descripcion;
    
    public final static List<TipoPeriodoEnum> list=new ArrayList<TipoPeriodoEnum>();

	public final static Map<Integer, TipoPeriodoEnum> lookup=new HashMap<Integer, TipoPeriodoEnum>();

	static {
		for(TipoPeriodoEnum c : TipoPeriodoEnum.values()){
			lookup.put(c.getCodigo(), c);
			list.add( c );
		}
	}
    
    private TipoPeriodoEnum(Integer codigo, String descripcion) {   
         this.codigo = codigo;
         this.descripcion = descripcion;
    }

    public Integer getCodigo() {
		return codigo;
	}

	public String getDescripcion() {
        return descripcion;
    }  
	
	public static TipoPeriodoEnum get(Integer codigo) {
		return lookup.get(codigo);
	}
 
}
