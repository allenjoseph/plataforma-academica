/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@EntityListeners(AuditLogger.class)
@Table(name = "archivo", catalog = "platacad", schema = "")
public class Archivo implements Serializable, Auditable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_archivo_pk", nullable = false)
    private Integer idArchivoPk;
    
    @Lob
    @Column(name = "contenido")
    private byte[] contenido;
        
    @OneToMany(mappedBy = "idArchivoFk")
    private List<Articulo> articuloList;
    
    @OneToMany(mappedBy = "idArchivoFk")
    private List<Documento> documentoList;
    
    @JoinColumn(name = "id_usuario_fk", referencedColumnName = "id_usuario_pk")
    @ManyToOne
    private Usuario idUsuarioFk;
    
    @OneToMany(mappedBy = "idArchivoFk")
    private List<DetalleTrabajo> detalleTrabajoList;
    
    @Embedded
    private Auditoria auditoria = new Auditoria();
    
    @Column(name = "estado_param")
    private Integer estado;

    public Archivo() {
    }

    public Archivo(Integer idArchivoPk) {
        this.idArchivoPk = idArchivoPk;
    }

    public Integer getIdArchivoPk() {
        return idArchivoPk;
    }

    public void setIdArchivoPk(Integer idArchivoPk) {
        this.idArchivoPk = idArchivoPk;
    }

    public byte[] getContenido() {
        return contenido;
    }

    public void setContenido(byte[] contenido) {
        this.contenido = contenido;
    }

    public List<Articulo> getArticuloList() {
        return articuloList;
    }

    public void setArticuloList(List<Articulo> articuloList) {
        this.articuloList = articuloList;
    }

    public List<Documento> getDocumentoList() {
        return documentoList;
    }

    public void setDocumentoList(List<Documento> documentoList) {
        this.documentoList = documentoList;
    }

    public Usuario getIdUsuarioFk() {
        return idUsuarioFk;
    }

    public void setIdUsuarioFk(Usuario idUsuarioFk) {
        this.idUsuarioFk = idUsuarioFk;
    }

    public List<DetalleTrabajo> getDetalleTrabajoList() {
        return detalleTrabajoList;
    }

    public void setDetalleTrabajoList(List<DetalleTrabajo> detalleTrabajoList) {
        this.detalleTrabajoList = detalleTrabajoList;
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
		this.auditoria.prePresist();
	}

	public void preUpdate() {
		this.auditoria.preUpdate();		
	}    
}
