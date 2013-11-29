/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.entities.enums;

/**
 *
 * @author hp38
 */

public enum TipoCursoEnum {
    OBLIGATORIO(5,"CURSO DE CARACTER OBLIGATORIO"),
    ELECTIVO(6,"CURSO DE CARACTER ELECTIVO");

    private final int id;
    private final String descripcion;
    
    private TipoCursoEnum(int id, String descripcion) {   
         this.id = id;
         this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }    
    
    public static TipoCursoEnum obtenerEnum(int id){
        switch(id){
            case 5:
                return OBLIGATORIO;
            case 6:
                return ELECTIVO;
            default:
            	return OBLIGATORIO;
        }        
    }
}
