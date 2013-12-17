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
    
    @Embedded
    private Auditoria auditoria;
    
    @JoinColumn(name = "id_usuario_fk", referencedColumnName = "id_usuario_pk")
    @ManyToOne
    private Usuario idUsuarioFk;
    
    @JoinColumn(name = "id_articulo_fk", referencedColumnName = "id_articulo_pk")
    @ManyToOne
    private Articulo idArticuloFk;
    
    @Column(name = "estado_param")
    private Integer estado;

    public Comentario() {
    }

    public Comentario(Integer idComentarioPk) {
        this.idComentarioPk = idComentarioPk;
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
    
    public Auditoria getAuditoria() {
		return auditoria;
	}

	public void setAuditoria(Auditoria auditoria) {
		this.auditoria = auditoria;
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

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

}
