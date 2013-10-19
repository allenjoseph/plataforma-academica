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
@Table(name = "mensaje", catalog = "platacad", schema = "")
@NamedQueries({
    @NamedQuery(name = "Mensaje.findAll", query = "SELECT m FROM Mensaje m"),
    @NamedQuery(name = "Mensaje.findByIdMensajePk", query = "SELECT m FROM Mensaje m WHERE m.idMensajePk = :idMensajePk"),
    @NamedQuery(name = "Mensaje.findByMensaje", query = "SELECT m FROM Mensaje m WHERE m.mensaje = :mensaje"),
    @NamedQuery(name = "Mensaje.findByModificacionFecha", query = "SELECT m FROM Mensaje m WHERE m.modificacionFecha = :modificacionFecha"),
    @NamedQuery(name = "Mensaje.findByModificacionUsuario", query = "SELECT m FROM Mensaje m WHERE m.modificacionUsuario = :modificacionUsuario")})
public class Mensaje extends Auditoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mensaje_pk", nullable = false)
    private Integer idMensajePk;
    @Column(name = "mensaje", length = 255)
    private String mensaje;
    @Column(name = "asunto", length = 255)
    private String asunto;    
    @Basic(optional = false)
    @Column(name = "modificacion_fecha", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacionFecha;
    @Basic(optional = false)
    @Column(name = "modificacion_usuario", nullable = false, length = 10)
    private String modificacionUsuario;
    @JoinColumn(name = "id_usuario_destino_fk", referencedColumnName = "id_usuario_pk")
    @ManyToOne
    private Usuario idUsuarioDestinoFk;
    @JoinColumn(name = "id_usuario_fk", referencedColumnName = "id_usuario_pk")
    @ManyToOne
    private Usuario idUsuarioFk;
    @JoinColumn(name = "id_curso_destino_fk", referencedColumnName = "id_curso_pk")
    @ManyToOne
    private Curso idCursoDestinoFk;

    public Mensaje() {
    }

    public Mensaje(Integer idMensajePk) {
        this.idMensajePk = idMensajePk;
    }

    public Mensaje(Integer idMensajePk, Date modificacionFecha, String modificacionUsuario) {
        this.idMensajePk = idMensajePk;
        this.modificacionFecha = modificacionFecha;
        this.modificacionUsuario = modificacionUsuario;
    }

    public Integer getIdMensajePk() {
        return idMensajePk;
    }

    public void setIdMensajePk(Integer idMensajePk) {
        this.idMensajePk = idMensajePk;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
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

    public Usuario getIdUsuarioDestinoFk() {
        return idUsuarioDestinoFk;
    }

    public void setIdUsuarioDestinoFk(Usuario idUsuarioDestinoFk) {
        this.idUsuarioDestinoFk = idUsuarioDestinoFk;
    }

    public Usuario getIdUsuarioFk() {
        return idUsuarioFk;
    }

    public void setIdUsuarioFk(Usuario idUsuarioFk) {
        this.idUsuarioFk = idUsuarioFk;
    }

    public Curso getIdCursoDestinoFk() {
        return idCursoDestinoFk;
    }

    public void setIdCursoDestinoFk(Curso idCursoDestinoFk) {
        this.idCursoDestinoFk = idCursoDestinoFk;
    }

    public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idMensajePk != null ? idMensajePk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mensaje)) {
            return false;
        }
        Mensaje other = (Mensaje) object;
        if ((this.idMensajePk == null && other.idMensajePk != null) || (this.idMensajePk != null && !this.idMensajePk.equals(other.idMensajePk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.platacad.entities.Mensaje[ idMensajePk=" + idMensajePk + " ]";
    }
    
}
