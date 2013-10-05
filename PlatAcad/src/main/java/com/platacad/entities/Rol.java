/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author allen
 */
@Entity
@Table(name = "rol", catalog = "platacad", schema = "")
@NamedQueries({
    @NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r"),
    @NamedQuery(name = "Rol.findByIdRoPk", query = "SELECT r FROM Rol r WHERE r.idRoPk = :idRoPk"),
    @NamedQuery(name = "Rol.findByDescripcion", query = "SELECT r FROM Rol r WHERE r.descripcion = :descripcion")})
public class Rol implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_ro_pk", nullable = false)
    private Integer idRoPk;
    @Column(name = "descripcion", length = 255)
    private String descripcion;
    @OneToMany(mappedBy = "idRolFk")
    private List<Usuario> usuarioList;

    public Rol() {
    }

    public Rol(Integer idRoPk) {
        this.idRoPk = idRoPk;
    }

    public Integer getIdRoPk() {
        return idRoPk;
    }

    public void setIdRoPk(Integer idRoPk) {
        this.idRoPk = idRoPk;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRoPk != null ? idRoPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.idRoPk == null && other.idRoPk != null) || (this.idRoPk != null && !this.idRoPk.equals(other.idRoPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.platacad.entities.Rol[ idRoPk=" + idRoPk + " ]";
    }
    
}
