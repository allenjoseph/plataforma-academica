/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.model.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hp38
 */

public enum TipoCursoEnum {
	
    OBLIGATORIO(Integer.valueOf(3), "OBLIGATORIO"),
    
    ELECTIVO(Integer.valueOf(4), "ELECTIVO");
    
    private final Integer codigo;
	
    private final String descripcion;
    
    public final static List<TipoCursoEnum> list=new ArrayList<TipoCursoEnum>();

	public final static Map<Integer, TipoCursoEnum> lookup=new HashMap<Integer, TipoCursoEnum>();

	static {
		for(TipoCursoEnum c : TipoCursoEnum.values()){
			lookup.put(c.getCodigo(), c);
			list.add( c );
		}
	}
    
    private TipoCursoEnum(Integer codigo, String descripcion) {   
         this.codigo = codigo;
         this.descripcion = descripcion;
    }

    public Integer getCodigo() {
		return codigo;
	}

	public String getDescripcion() {
        return descripcion;
    }  
	
	public static TipoCursoEnum get(Integer codigo) {
		return lookup.get(codigo);
	}
 
}
