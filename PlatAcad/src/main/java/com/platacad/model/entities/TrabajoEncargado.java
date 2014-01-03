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
@Table(name = "trabajo_encargado", catalog = "platacad", schema = "")
public class TrabajoEncargado implements Serializable, Auditable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_trabajo_pk", nullable = false)
    private Integer idTrabajoPk;
    
    @Column(name = "titulo", length = 255)
    private String titulo;
    
    @Lob
    @Column(name = "descripcion", length = 65535)
    private String descripcion;
    
    @Column(name = "fecha_presentacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPresentacion;
    
    @Column(name = "estado_param")
    private Integer estado;
    
    @Embedded
    private Auditoria auditoria = new Auditoria();

    @Column(name = "tipo_param")
    private Integer tipo;
    
    @JoinColumn(name = "id_curso_aperturado_fk", referencedColumnName = "id_curso_aperturado_pk", nullable = false)
    @ManyToOne(optional = false)
    private CursoAperturado idCursoAperturadoFk;
    
    @OneToMany(mappedBy = "idTrabajoFk")
    private List<DetalleTrabajo> detalleTrabajoList;

    public TrabajoEncargado() {
    }

    public TrabajoEncargado(Integer idTrabajoPk) {
        this.idTrabajoPk = idTrabajoPk;
    }

    public Integer getIdTrabajoPk() {
        return idTrabajoPk;
    }

    public void setIdTrabajoPk(Integer idTrabajoPk) {
        this.idTrabajoPk = idTrabajoPk;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaPresentacion() {
        return fechaPresentacion;
    }

    public void setFechaPresentacion(Date fechaPresentacion) {
        this.fechaPresentacion = fechaPresentacion;
    }
   
    public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Auditoria getAuditoria() {
		return auditoria;
	}

	public void setAuditoria(Auditoria auditoria) {
		this.auditoria = auditoria;
	}

    public CursoAperturado getIdCursoAperturadoFk() {
        return idCursoAperturadoFk;
    }

    public void setIdCursoAperturadoFk(CursoAperturado idCursoAperturadoFk) {
        this.idCursoAperturadoFk = idCursoAperturadoFk;
    }

    public List<DetalleTrabajo> getDetalleTrabajoList() {
        return detalleTrabajoList;
    }

    public void setDetalleTrabajoList(List<DetalleTrabajo> detalleTrabajoList) {
        this.detalleTrabajoList = detalleTrabajoList;
    }
    
    public void prePresist() {
		this.auditoria.prePresist();
	}

	public void preUpdate() {
		this.auditoria.preUpdate();		
	}
}
