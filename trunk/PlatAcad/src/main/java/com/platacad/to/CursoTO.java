/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.to;

import java.io.Serializable;

import com.platacad.entities.Auditoria;
import com.platacad.entities.enums.TipoCursoEnum;

/**
 *
 * @author allen
 */
public class CursoTO extends Auditoria implements Serializable {
    
    private String nombre;
    private Integer creditos;
    private TipoCursoEnum tipo;

    public CursoTO() {
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

    public TipoCursoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoCursoEnum tipo) {
        this.tipo = tipo;
    }
    
}
