/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.to;

import java.io.Serializable;

import com.platacad.model.entities.Auditoria;

/**
 *
 * @author allen
 */
public class UsuarioTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String codigo;
	
    private String nombreCompleto;

    public UsuarioTO() {
    }
    
    public UsuarioTO(String codigo,String nombreCompleto){
    	this.codigo = codigo;
    	this.nombreCompleto = nombreCompleto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
}
