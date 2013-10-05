/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.to;

/**
 *
 * @author allen
 */
public class UsuarioTO {

    private String codigo;
    private String nombre;
    private String nombreCompleto;
    
    private int rolId;
    private String rol;

    public UsuarioTO() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
