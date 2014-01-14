/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author allen
 */
@Entity
@EntityListeners(AuditLogger.class)
@Table(name = "mensaje", catalog = "platacad", schema = "")
public class Mensaje implements Serializable, Auditable {
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
   
    @JoinColumn(name = "id_usuario_destino_fk", referencedColumnName = "id_usuario_pk")
    @ManyToOne
    private Usuario idUsuarioDestinoFk;
    
    @JoinColumn(name = "id_usuario_fk", referencedColumnName = "id_usuario_pk")
    @ManyToOne
    private Usuario idUsuarioFk;
    
    @JoinColumn(name = "id_curso_destino_fk", referencedColumnName = "id_curso_pk")
    @ManyToOne
    private Curso idCursoDestinoFk;
    
    @Column(name = "estado_param")
    private Integer estado;
    
    @Embedded
    private Auditoria auditoria = new Auditoria();

    public Mensaje() {
    }
    
    public Mensaje(Usuario idUsuarioFk) {
    	this.idUsuarioFk = idUsuarioFk;
    }

    public Mensaje(Integer idMensajePk) {
        this.idMensajePk = idMensajePk;
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

	public Auditoria getAuditoria() {
		return auditoria;
	}

	public void setAuditoria(Auditoria auditoria) {
		this.auditoria = auditoria;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public void prePresist() {
		auditoria.prePresist();
	}

	public void preUpdate() {
		auditoria.preUpdate();	
	}
    
}
