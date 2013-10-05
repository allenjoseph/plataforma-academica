/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.to;

/**
 *
 * @author allen
 */
public class CursoTO {
    
    private String nombre;
    private int creditos;
    private TipoTO tipo;

    public CursoTO() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public TipoTO getTipo() {
        return tipo;
    }

    public void setTipo(TipoTO tipo) {
        this.tipo = tipo;
    }
    
}
