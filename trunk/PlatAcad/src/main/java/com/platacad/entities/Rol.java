/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author allen
 */
@Entity
@Table(name = "rol", catalog = "platacad", schema = "")
@NamedQueries({
    @NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r"),
    @NamedQuery(name = "Rol.findByIdRolPk", query = "SELECT r FROM Rol r WHERE r.idRolPk = :idRolPk"),
    @NamedQuery(name = "Rol.findByDescripcion", query = "SELECT r FROM Rol r WHERE r.descripcion = :descripcion"),
    @NamedQuery(name = "Rol.findByModificacionFecha", query = "SELECT r FROM Rol r WHERE r.modificacionFecha = :modificacionFecha"),
    @NamedQuery(name = "Rol.findByModificacionUsuario", query = "SELECT r FROM Rol r WHERE r.modificacionUsuario = :modificacionUsuario")})
public class Rol implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rol_pk", nullable = false)
    private Integer idRolPk;
    @Column(name = "descripcion", length = 255)
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "modificacion_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacionFecha;
    @Basic(optional = false)
    @Column(name = "modificacion_usuario", nullable = false, length = 10)
    private String modificacionUsuario;
    @OneToMany(mappedBy = "idRolFk")
    private List<Usuario> usuarioList;

    public Rol() {
    }

    public Rol(Integer idRolPk) {
        this.idRolPk = idRolPk;
    }

    public Rol(Integer idRolPk, Date modificacionFecha, String modificacionUsuario) {
        this.idRolPk = idRolPk;
        this.modificacionFecha = modificacionFecha;
        this.modificacionUsuario = modificacionUsuario;
    }

    public Integer getIdRolPk() {
        return idRolPk;
    }

    public void setIdRolPk(Integer idRolPk) {
        this.idRolPk = idRolPk;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getModificacionFecha() {
        return modificacionFecha;
    }

    public void setModificacionFecha(Date modificacionFecha) {
        this.modificacionFecha = modificacionFecha;
    }

    public String getModificacionUsuario() {
        return modificacionUsuario;
    }

    public void setModificacionUsuario(String modificacionUsuario) {
        this.modificacionUsuario = modificacionUsuario;
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
        hash += (idRolPk != null ? idRolPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.idRolPk == null && other.idRolPk != null) || (this.idRolPk != null && !this.idRolPk.equals(other.idRolPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.platacad.entities.Rol[ idRolPk=" + idRolPk + " ]";
    }
    
}
