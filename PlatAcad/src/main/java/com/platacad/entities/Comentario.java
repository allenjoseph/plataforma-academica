/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author allen
 */
@Entity
@Table(name = "comentario", catalog = "platacad", schema = "")
@NamedQueries({
    @NamedQuery(name = "Comentario.findAll", query = "SELECT c FROM Comentario c"),
    @NamedQuery(name = "Comentario.findByIdComentarioPk", query = "SELECT c FROM Comentario c WHERE c.idComentarioPk = :idComentarioPk"),
    @NamedQuery(name = "Comentario.findByModificacionFecha", query = "SELECT c FROM Comentario c WHERE c.modificacionFecha = :modificacionFecha"),
    @NamedQuery(name = "Comentario.findByModificacionUsuario", query = "SELECT c FROM Comentario c WHERE c.modificacionUsuario = :modificacionUsuario")})
public class Comentario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_comentario_pk", nullable = false)
    private Integer idComentarioPk;
    @Lob
    @Column(name = "contenido", length = 65535)
    private String contenido;
    @Basic(optional = false)
    @Column(name = "modificacion_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacionFecha;
    @Basic(optional = false)
    @Column(name = "modificacion_usuario", nullable = false, length = 10)
    private String modificacionUsuario;
    @JoinColumn(name = "id_usuario_fk", referencedColumnName = "id_usuario_pk")
    @ManyToOne
    private Usuario idUsuarioFk;
    @JoinColumn(name = "id_articulo_fk", referencedColumnName = "id_articulo_pk")
    @ManyToOne
    private Articulo idArticuloFk;

    public Comentario() {
    }

    public Comentario(Integer idComentarioPk) {
        this.idComentarioPk = idComentarioPk;
    }

    public Comentario(Integer idComentarioPk, Date modificacionFecha, String modificacionUsuario) {
        this.idComentarioPk = idComentarioPk;
        this.modificacionFecha = modificacionFecha;
        this.modificacionUsuario = modificacionUsuario;
    }

    public Integer getIdComentarioPk() {
        return idComentarioPk;
    }

    public void setIdComentarioPk(Integer idComentarioPk) {
        this.idComentarioPk = idComentarioPk;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
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

    public Usuario getIdUsuarioFk() {
        return idUsuarioFk;
    }

    public void setIdUsuarioFk(Usuario idUsuarioFk) {
        this.idUsuarioFk = idUsuarioFk;
    }

    public Articulo getIdArticuloFk() {
        return idArticuloFk;
    }

    public void setIdArticuloFk(Articulo idArticuloFk) {
        this.idArticuloFk = idArticuloFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComentarioPk != null ? idComentarioPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comentario)) {
            return false;
        }
        Comentario other = (Comentario) object;
        if ((this.idComentarioPk == null && other.idComentarioPk != null) || (this.idComentarioPk != null && !this.idComentarioPk.equals(other.idComentarioPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.platacad.entities.Comentario[ idComentarioPk=" + idComentarioPk + " ]";
    }
    
}
