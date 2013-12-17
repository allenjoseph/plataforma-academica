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
@Table(name = "detalle_trabajo", catalog = "platacad", schema = "")
public class DetalleTrabajo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle_pk", nullable = false)
    private Integer idDetallePk;
    
    @Embedded
    private Auditoria auditoria;
    
    @Column(name = "estado_param")
    private Integer estado;
    
    @JoinColumn(name = "id_archivo_fk", referencedColumnName = "id_archivo_pk")
    @ManyToOne
    private Archivo idArchivoFk;
    
    @JoinColumn(name = "id_trabajo_fk", referencedColumnName = "id_trabajo_pk")
    @ManyToOne
    private TrabajoEncargado idTrabajoFk;

    public DetalleTrabajo() {
    }

    public DetalleTrabajo(Integer idDetallePk) {
        this.idDetallePk = idDetallePk;
    }

    public Integer getIdDetallePk() {
        return idDetallePk;
    }

    public void setIdDetallePk(Integer idDetallePk) {
        this.idDetallePk = idDetallePk;
    }

    public Auditoria getAuditoria() {
		return auditoria;
	}

	public void setAuditoria(Auditoria auditoria) {
		this.auditoria = auditoria;
	}

	public Archivo getIdArchivoFk() {
        return idArchivoFk;
    }

    public void setIdArchivoFk(Archivo idArchivoFk) {
        this.idArchivoFk = idArchivoFk;
    }

    public TrabajoEncargado getIdTrabajoFk() {
        return idTrabajoFk;
    }

    public void setIdTrabajoFk(TrabajoEncargado idTrabajoFk) {
        this.idTrabajoFk = idTrabajoFk;
    }

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

}
