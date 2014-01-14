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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author allen
 */
@Entity
@EntityListeners(AuditLogger.class)
@Table(name = "documento", catalog = "platacad", schema = "")
public class Documento implements Serializable, Auditable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_documento", nullable = false)
    private Integer idDocumento;
    
    @Column(name = "titulo", length = 255)
    private String titulo;
    
    @Embedded
    private Auditoria auditoria = new Auditoria();
    
    @Column(name = "tipo_param")
    private Integer tipo;
    
    @Column(name = "estado_param")
    private Integer estado;
    
    @JoinColumn(name = "id_archivo_fk", referencedColumnName = "id_archivo_pk")
    @ManyToOne
    private Archivo idArchivoFk;

    public Documento() {
    }

    public Documento(Integer idDocumento) {
        this.idDocumento = idDocumento;
    }

    public Integer getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Integer idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Auditoria getAuditoria() {
		return auditoria;
	}

	public void setAuditoria(Auditoria auditoria) {
		this.auditoria = auditoria;
	}
	
    public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Archivo getIdArchivoFk() {
        return idArchivoFk;
    }

    public void setIdArchivoFk(Archivo idArchivoFk) {
        this.idArchivoFk = idArchivoFk;
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
